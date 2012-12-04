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

import metier.Agent;
import metier.AgentComptable;
import metier.TypeErreur;
import tools.Check;
import bdd.AgentDAO;
import bdd.TypeErreurDAO;

/**
 * Servlet implementation class DeclarerErreur
 */
public class DeclarerErreurServlet extends HttpServlet {
    private static final long      serialVersionUID = 1L;

    private static final int       SUCCES           = 0;
    private static final int       ECHEC            = 1;

    private ArrayList<TypeErreur>  typesErreurs;

    public HashMap<String, String> erreurs;

    private Formulaire             form             = null;

    public DeclarerErreurServlet() {
        super();
        form = new Formulaire();
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        Agent agent = null;
        if ( Check.checkAgent( request ) )
        {
            agent = AgentDAO.selectByCode( (String) request.getSession()
                    .getAttribute( "codeAgent" ) );
            if ( Check.checkTypeAgent( "comptable", agent ) )
                setTypesErreurs( TypeErreurDAO.selectAll() );
            else
                form.setErreur( "droit", "Accès refusé." );
        }
        else
        {
            response.sendRedirect( "LoginServlet" );
            return;
        }

        this.getServletContext().setAttribute( "this", this );

        this.getServletContext().getRequestDispatcher( "/WEB-INF/agent-comptable/declarer-erreur.jsp" )
                .forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        boolean rediriger = false;
        boolean actualiser = false;
        try {

            Agent agent = null;
            if ( Check.checkAgent( request ) )
            {
                agent = AgentDAO.selectByCode( (String) request.getSession()
                        .getAttribute( "codeAgent" ) );
                if ( Check.checkTypeAgent( "comptable", agent ) )
                {
                    AgentComptable agentComptable = (AgentComptable) agent;
                    form.recupererEtVerifierFormulaire( request );

                    if ( form.getResultat() == SUCCES )
                    {
                        Agent a = AgentDAO.selectByCode( form.getCodeAgent() );
                        agentComptable.declarerErreurCaisse( a.getAgence().getCodeAgence(), a.getCodeAgent(),
                                new Date(),
                                form.getCodeTypeErreur(), form.getMontant() );
                    }
                    else
                    {
                    	// réaffiche la page si erreur
                    	actualiser = true;
                    }
                }
                else
                    form.setErreur( "droit", "Accès refusé." );
            }
            else
                rediriger = true;
        } catch ( SQLException e ) {
            e.printStackTrace();
            form.setErreur( "bdd", "La base de donnee a rencontre un probleme. Recherche abandonnee." );
        } finally {
        	if ( actualiser )
        		this.getServletContext()
                .getRequestDispatcher(
                        "/WEB-INF/agent-comptable/declarer-erreur.jsp" )
                .forward( request, response );
        	else if ( rediriger )
                response.sendRedirect( "LoginServlet" );
            else
                response.sendRedirect( "AccueilAgentComptableServlet" );
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
        private float               montant           = -1;
        private String              codeTypeErreur    = null;

        private int                 resultat;

        public Formulaire recupererEtVerifierFormulaire( HttpServletRequest request ) {

            erreurs = new HashMap<String, String>();
            String codeAgentString = getValeurChamp( request, CHAMP_CODE_AGENT );
            String montantString = getValeurChamp( request, CHAMP_MONTANT );
            String codeTypeErreurString = getValeurChamp( request, CHAMP_TYPE_ERREUR );

            try {
                validationCodeAgent( codeAgentString, request );
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

        private void validationCodeAgent( String codeAgentString, HttpServletRequest request ) throws Exception {
            if ( codeAgentString != null )
            {
                if (AgentDAO.selectByCode( codeAgentString ) != null)
                {
                	if (AgentDAO.selectByCode( codeAgentString ).getAgence().getCodeAgence() == 
                	AgentDAO.selectByCode( (String) request.getSession().getAttribute( "codeAgent" )).getAgence().getCodeAgence())
                	{
                		setCodeAgent( codeAgentString );
                	}
                	else
                		throw new Exception( "Agent inconnu" );
                }
                else
                    throw new Exception( "Agent inconnu" );
            }
            else
                throw new Exception( "Agent inconnu" );
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
                    setMontant( Float.valueOf( montantString ).floatValue() );
                } catch ( NumberFormatException e ) {
                    throw new Exception( "Montant invalide" );
                }
            }
            else
            	setErreur(CHAMP_MONTANT, "Saisir le montant de l'erreur");
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

        public float getMontant() {
            return montant;
        }

        public void setMontant( float montant ) {
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
