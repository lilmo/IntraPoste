package agentcomptable;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Agent;
import metier.AgentComptable;
import metier.TypeErreur;
import bdd.AgentDAO;
import bdd.TypeErreurDAO;

/**
 * Servlet implementation class DeclarerErreur
 */
public class DeclarerErreur extends HttpServlet {
    private static final long      serialVersionUID = 1L;

    private static final int       SUCCES           = 0;
    private static final int       ECHEC            = 1;

    private ArrayList<TypeErreur>  typesErreurs;

    public HashMap<String, String> erreurs;

    private Formulaire             form             = null;

    public DeclarerErreur() {
        super();
        // TODO Auto-generated constructor stub
        form = new Formulaire();
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        setTypesErreurs( TypeErreurDAO.selectAll() );

        this.getServletContext().setAttribute( "this", this );

        this.getServletContext().getRequestDispatcher( "/WEB-INF/agent-comptable/declarer-erreur.jsp" )
                .forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        boolean rediriger = false;
        try {
            form.recupererEtVerifierFormulaire( request );

            if ( form.getResultat() == SUCCES )
            {
                HttpSession session = request.getSession();
                /* R�cup�ration de l'objet depuis la session */

                AgentComptable agent = null;
                try {
                    agent = (AgentComptable) session.getAttribute( "agent" );
                } catch ( ClassCastException e )
                {
                    e.printStackTrace();
                    form.setErreur( "", "Vous n'�tes pas autoris� � effectuer cette op�ration" );
                }
                if ( agent != null )
                {
                    Agent a = AgentDAO.selectByCode( form.getCodeAgent() );
                    agent.declarerErreurCaisse( a.getAgence().getCodeAgence(), a.getCodeAgent(), new Date(),
                            form.getCodeTypeErreur(), form.getMontant() );
                }
                else
                    rediriger = true;
            } // Sinon les erreurs seront affich�es via la jsp

        } catch ( SQLException e ) {
            e.printStackTrace();
            form.setErreur( "", "La base de donnee a rencontre un probleme. Recherche abandonnee." );
        } finally {
            if ( rediriger )
                response.sendRedirect( "LoginServlet" );
            else
                this.getServletContext().getRequestDispatcher( "/WEB-INF/agent-comptable/accueil-agent-comptable.jsp" )
                        .forward( request, response );
        }

    }

    public ArrayList<TypeErreur> getTypesErreurs() {
        return typesErreurs;
    }

    public void setTypesErreurs( ArrayList<TypeErreur> typesErreurs ) {
        this.typesErreurs = typesErreurs;
    }

    public HashMap<String, String> getErreurs() {
        return erreurs;
    }

    public void setErreurs( HashMap<String, String> erreurs ) {
        this.erreurs = erreurs;
    }

    private class Formulaire
    {
        private static final String CHAMP_CODE_AGENT  = "codeAgent";
        private static final String CHAMP_TYPE_ERREUR = "typeErreur";
        private static final String CHAMP_MONTANT     = "montant";

        private String              codeAgent         = null;
        private int                 montant           = -1;
        private String              codeTypeErreur    = null;

        private int                 resultat;

        public Formulaire recupererEtVerifierFormulaire( HttpServletRequest request ) {

            erreurs = new HashMap<String, String>();
            String codeAgentString = getValeurChamp( request, CHAMP_CODE_AGENT );
            String montantString = getValeurChamp( request, CHAMP_MONTANT );
            String codeTypeErreurString = getValeurChamp( request, CHAMP_TYPE_ERREUR );

            try {
                validationCodeAgent( codeAgentString );
            } catch ( Exception e ) {
                setErreur( CHAMP_CODE_AGENT, e.getMessage() );
                setCodeAgent( null );
            }

            try {
                validationMontant( montantString );
            } catch ( Exception e ) {
                setErreur( CHAMP_MONTANT, e.getMessage() );
                setMontant( -1 );
            }

            try {
                validationTypeErreur( codeTypeErreurString );
            } catch ( Exception e ) {
                setErreur( CHAMP_TYPE_ERREUR, e.getMessage() );
                setCodeTypeErreur( null );
            }

            if ( erreurs.isEmpty() ) {
                setResultat( SUCCES );
            } else {
                setResultat( ECHEC );
            }

            return this;
        }

        private String getValeurChamp( HttpServletRequest request, String nomChamp ) {
            String valeur = request.getParameter( nomChamp );
            if ( valeur == null || valeur.trim().length() == 0 ) {
                return null;
            } else {
                return valeur.trim();
            }
        }

        /* Validation des champs */

        private void validationCodeAgent( String codeAgentString ) throws Exception {
            if ( codeAgentString != null )
            {
                if ( AgentDAO.selectByCode( codeAgentString ) != null )
                    setCodeAgent( codeAgentString );
                else
                    throw new Exception( "Agent inconnu" );
            }
        }

        private void validationTypeErreur( String codeTypeErreurString ) throws Exception {
            if ( codeTypeErreurString != null )
            {
                if ( codeTypeErreurString.equals( "E" ) || codeTypeErreurString.equals( "D" ) )
                    setCodeTypeErreur( codeTypeErreurString );
                else
                    throw new Exception( "Type d'erreur inconnu" );
            }
        }

        private void validationMontant( String montantString ) throws Exception {
            if ( montantString != null )
            {
                try {
                    setMontant( Integer.parseInt( montantString ) );
                } catch ( NumberFormatException e ) {
                    throw new Exception( "Montant invalide" );
                }
            }
        }

        /* Getters and Setters */

        private void setErreur( String champ, String message ) {
            erreurs.put( champ, message );
        }

        public String getCodeAgent() {
            return codeAgent;
        }

        public void setCodeAgent( String codeAgent ) {
            this.codeAgent = codeAgent;
        }

        public int getMontant() {
            return montant;
        }

        public void setMontant( int montant ) {
            this.montant = montant;
        }

        public String getCodeTypeErreur() {
            return codeTypeErreur;
        }

        public void setCodeTypeErreur( String codeTypeErreur ) {
            this.codeTypeErreur = codeTypeErreur;
        }

        public int getResultat() {
            return resultat;
        }

        public void setResultat( int resultat ) {
            this.resultat = resultat;
        }

    }

}