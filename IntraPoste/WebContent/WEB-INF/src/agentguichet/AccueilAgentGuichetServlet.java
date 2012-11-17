package agentguichet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.AgentGuichet;
import metier.ErreurCaisse;
import metier.StatusRegularisation;
import metier.TypeErreur;
import bdd.ErreurCaisseDAO;
import bdd.StatusRegularisationDAO;
import bdd.TypeErreurDAO;

/**
 * Servlet implementation class AccueilAgentGuichetServlet
 */
public class AccueilAgentGuichetServlet extends HttpServlet {
    private static final long               serialVersionUID = 1L;
    private static final int                SUCCES           = 0;
    private static final int                ECHEC            = 1;

    private ArrayList<ErreurCaisse>         erreursCaisse;
    private ArrayList<TypeErreur>           typesErreurs;
    private ArrayList<StatusRegularisation> statusRegularisation;

    private RechercheForm                   recherche;

    public AccueilAgentGuichetServlet() {
        super();
        setErreursCaisse( null );
        setTypesErreurs( null );
        setStatusRegularisation( null );

        recherche = new RechercheForm();
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        try {
            recherche.recupererEtVerifierFormulaire( request );

            if ( recherche.getResultat() == SUCCES )
            {
                HttpSession session = request.getSession();
                /* Récupération de l'objet depuis la session */

                AgentGuichet agent = (AgentGuichet) session.getAttribute( "agent" );

                setErreursCaisse( ErreurCaisseDAO.selectErreursCaisseByAgent( agent.getCodeAgent(),
                        recherche.getDateDebut(), recherche.getDateFin(),
                        recherche.getCodeTypeErreur(),
                        recherche.getCodeStatusRegularisation() ) );

                if ( erreursCaisse.isEmpty() )
                {
                    setErreursCaisse( ErreurCaisseDAO.selectAll() );
                    recherche.setErreur( "noResult", "Aucun resultat ne correspond a votre recherche." );
                }
            }
            else
                setErreursCaisse( ErreurCaisseDAO.selectAll() );

            setTypesErreurs( TypeErreurDAO.selectAll() );
            setStatusRegularisation( StatusRegularisationDAO.selectAll() );

            this.getServletContext().setAttribute( "this", this );

        } catch ( SQLException e ) {
            e.printStackTrace();
            recherche.setErreur( "", "La base de donnee a rencontre un probleme. Recherche abandonnee." );
        } finally {
            this.getServletContext().getRequestDispatcher( "/WEB-INF/agent-guichet/accueil-agent-guichet.jsp" )
                    .forward( request, response );
        }
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        doGet( request, response );
    }

    public ArrayList<ErreurCaisse> getErreursCaisse() {
        return erreursCaisse;
    }

    public void setErreursCaisse( ArrayList<ErreurCaisse> erreurs ) {
        this.erreursCaisse = erreurs;
    }

    public ArrayList<StatusRegularisation> getStatusRegularisation() {
        return statusRegularisation;
    }

    public void setStatusRegularisation( ArrayList<StatusRegularisation> statusRegularisation ) {
        this.statusRegularisation = statusRegularisation;
    }

    public ArrayList<TypeErreur> getTypesErreurs() {
        return typesErreurs;
    }

    public void setTypesErreurs( ArrayList<TypeErreur> typesErreurs ) {
        this.typesErreurs = typesErreurs;
    }

    public RechercheForm getRecherche() {
        return recherche;
    }

    public void setRecherche( RechercheForm recherche ) {
        this.recherche = recherche;
    }

    private class RechercheForm
    {
        private static final String CHAMP_DEBUT                 = "dateDebut";
        private static final String CHAMP_FIN                   = "dateFin";
        private static final String CHAMP_TYPE_ERREUR           = "typeErreur";
        private static final String CHAMP_STATUS_REGULARISATION = "statusRegularisationRecherche";

        private Date                dateDebut;
        private Date                dateFin;
        private int                 codeStatusRegularisation;
        private String              codeTypeErreur;

        private Map<String, String> erreurs                     = new HashMap<String, String>();
        private int                 resultat;

        public RechercheForm recupererEtVerifierFormulaire( HttpServletRequest request ) {

            String dateDebutString = getValeurChamp( request, CHAMP_DEBUT );
            String dateFinString = getValeurChamp( request, CHAMP_FIN );
            String codeStatusRegularisationString = getValeurChamp( request, CHAMP_STATUS_REGULARISATION );
            String codeTypeErreurString = getValeurChamp( request, CHAMP_TYPE_ERREUR );

            try {
                setDateDebut( validationDate( dateDebutString ) );
            } catch ( Exception e ) {
                setErreur( CHAMP_DEBUT, e.getMessage() );
                setDateDebut( null );
            }

            try {
                setDateFin( validationDate( dateFinString ) );
            } catch ( Exception e ) {
                setErreur( CHAMP_FIN, e.getMessage() );
                setDateFin( null );
            }

            try {
                validationCodeStatus( codeStatusRegularisationString );
            } catch ( Exception e ) {
                setErreur( CHAMP_STATUS_REGULARISATION, e.getMessage() );
                setCodeStatusRegularisation( -1 );
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

        private void validationTypeErreur( String codeTypeErreurString ) throws Exception {
            if ( codeTypeErreurString.equals( "E" ) || codeTypeErreurString.equals( "D" ) )
                setCodeTypeErreur( codeTypeErreurString );
            else
                throw new Exception( "Type d'erreur inconnu" );
        }

        private void validationCodeStatus( String codeStatusRegularisationString ) throws Exception {
            if ( codeStatusRegularisationString != null )
            {
                try {
                    setCodeStatusRegularisation( Integer.parseInt( codeStatusRegularisationString ) );
                } catch ( NumberFormatException e ) {
                    e.printStackTrace();
                    throw new Exception( "Status de regularisation inconnu" );
                }
                if ( codeStatusRegularisation < 0 || codeStatusRegularisation > 2 )
                    throw new Exception( "Status de regularisation inconnu" );
            }
        }

        private Date validationDate( String dateString ) throws Exception {
            if ( dateString != null )
                try {
                    return new SimpleDateFormat( "dd/MM/yyyy" ).parse( dateString );
                } catch ( ParseException e ) {
                    e.printStackTrace();
                    throw new Exception( "Merci de saisir une date de debut valide." );
                }
            return null;
        }

        /* Getters and Setters */

        private void setErreur( String champ, String message ) {
            erreurs.put( champ, message );
        }

        public Date getDateDebut() {
            return dateDebut;
        }

        public void setDateDebut( Date dateDebut ) {
            this.dateDebut = dateDebut;
        }

        public Date getDateFin() {
            return dateFin;
        }

        public void setDateFin( Date dateFin ) {
            this.dateFin = dateFin;
        }

        public int getCodeStatusRegularisation() {
            return codeStatusRegularisation;
        }

        public void setCodeStatusRegularisation( int codeStatusRegularisation ) {
            this.codeStatusRegularisation = codeStatusRegularisation;
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
