/***********************************************************************
 * Module:  AgentComptable.java
 * Author:  Morgane
 * Purpose: Defines the Class AgentComptable
 ***********************************************************************/

package metier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import bdd.AgentDAO;
import bdd.ErreurCaisseDAO;

public class AgentComptable extends AgentSuperieur {

    public AgentComptable( String codeAgent, TypeAgent typeAgent, String mail,
            String nom, String prenom, String motDePasse, Agence agence ) {
        super( codeAgent, typeAgent, mail, nom, prenom, motDePasse, agence );
    }

    public int regulariserErreur( int idErreur, float montantRegularisation, String codeAgentRegularisateur,
            MotifRegularisation motifRegularisation ) throws SQLException
    {
        ErreurCaisse erreur = ErreurCaisseDAO.selectById( idErreur );
        if ( erreur != null )
            return erreur.regulariserErreurCaisseComptable( montantRegularisation, codeAgentRegularisateur,
                    motifRegularisation );
        return 3;
    }

    /**
     * @param codeAgence
     * @param codeAgent
     * @param dateVacation
     * @param codeTypeErreur
     * @param montant
     * @throws SQLException
     */
    public void declarerErreurCaisse( String codeAgence, String codeAgent,
            java.util.Date dateVacation, String codeTypeErreur, float montant ) throws SQLException {
        ErreurCaisseDAO.insert( codeAgence, codeAgent, dateVacation,
                codeTypeErreur, montant );
        float maxMontant = 10;
        try {
            float bilan = bilanErreursCaisse( codeAgence, dateVacation, null, -1 );
            if ( bilan > maxMontant || bilan + maxMontant < 0 )
                envoyerMail( getMailsDirection( codeAgence ) );
        } catch ( SQLException | MessagingException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @param mail
     * @throws SQLException
     */
    private ArrayList<String> getMailsDirection( String codeAgence ) throws SQLException {
        ArrayList<String> mails = new ArrayList<String>();
        ArrayList<Agent> agents = AgentDAO.selectByAgence( codeAgence );
        for ( Agent a : agents)
            if ( a.getTypeAgent().getCodeTypeAgent() != 2 && !a.getMail().equals( "" ) )
                mails.add( a.getMail() );
        return mails;
    }

    /**
     * @param mail
     * @throws MessagingException
     */
    private void envoyerMail( ArrayList<String> mails ) throws MessagingException {
        // TODO: implement
        String allMails = "";
        for ( String mail : mails )
            allMails += mail + ",";

        allMails = allMails.substring( 0, allMails.length() - 1 );
        
        final String username = "intraposte@gmail.com";
        final String password = "intraposte2012";
 
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
 
        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });
 
        try {
 
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("intraposte@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(allMails));
            message.setSubject("Bilan maximum dépassé.");
            message.setText("Attention, le bilan a été dépassé.");
 
            Transport.send(message);
 
            System.out.println("Done");
 
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}