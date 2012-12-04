package agentdirection;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Agence;
import metier.Agent;
import metier.AgentSuperieur;
import metier.ErreurCaisse;
import metier.StatusRegularisation;
import metier.TypeErreur;
import tools.Check;
import bdd.AgenceDAO;
import bdd.AgentDAO;
import bdd.StatusRegularisationDAO;
import bdd.TypeErreurDAO;

/**
 * Servlet implementation class BilanServlet
 */
public class BilanDirectionServlet extends HttpServlet {
    private static final long               serialVersionUID = 1L;
    private static final int                SUCCES           = 0;
    private static final int                ECHEC            = 1;

    private ArrayList<ErreurCaisse>         erreursCaisse;
    private ArrayList<TypeErreur>           typesErreurs;
    private ArrayList<StatusRegularisation> statusRegularisation;
    private float                           soldeAgence;
    private RechercheForm                   recherche;
    private Map<String, String>             erreurs;

    private Date                            dateDebut;
    private Date                            dateFin;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BilanDirectionServlet() {
        super();
        setErreursCaisse( null );
        setTypesErreurs( null );
        setStatusRegularisation( null );

        recherche = new RechercheForm();

        erreurs = new HashMap<String, String>();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException {
        boolean redirect = false;
        try {
            Agent agent = null;
            if ( Check.checkAgent( request ) ) {
                agent = AgentDAO.selectByCode( (String) request
                        .getSession().getAttribute( "codeAgent" ) );
                if ( ( !Check.checkTypeAgent( "comptable", agent ) ) && ( Check.checkTypeAgent( "superieur", agent ) ) ) {
                    AgentSuperieur agentSuperieur = (AgentSuperieur) agent;
                    recherche.recupererEtVerifierFormulaire( request );
                    if ( recherche.getResultat() == SUCCES ) {
                        if ( recherche.getCheckDate().equals( "journee" ) )
                            soldeAgence = agentSuperieur.bilanJourneeErreursCaisse(
                                    recherche.getAgence().getCodeAgence(),
                                    recherche.getDateJournee(),
                                    recherche.getCodeTypeErreur(),
                                    recherche.getCodeStatusRegularisation() );
                        else if ( recherche.getCheckDate().equals( "periode" ) )
                            soldeAgence = agentSuperieur.bilanErreursCaisse( recherche
                                    .getAgence().getCodeAgence(), recherche
                                    .getDatePeriode(), recherche
                                    .getCodeTypeErreur(), recherche
                                    .getCodeStatusRegularisation() );
                    } else
                        soldeAgence = 0;
                    setTypesErreurs( TypeErreurDAO.selectAll() );
                    setStatusRegularisation( StatusRegularisationDAO.selectAll() );
                    this.getServletContext().setAttribute( "this", this );
                } else
                    recherche.setErreur( "droit", "Accès refusé." );
            } else
                redirect = true;
        } catch ( SQLException e ) {
            e.printStackTrace();
            recherche
                    .setErreur( "bdd",
                            "La base de donnees a rencontre un probleme. Recherche abandonnee." );
        } finally {
            if ( redirect )
                response.sendRedirect( "LoginServlet" );
            else
                this.getServletContext()
                        .getRequestDispatcher(
                                "/WEB-INF/agent-direction/bilan-direction.jsp" )
                        .forward( request, response );
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException {
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

    public float getSoldeAgence() {
        return soldeAgence;
    }

    public void setSoldeAgence( float soldeAgence ) {
        this.soldeAgence = soldeAgence;
    }

    public void setStatusRegularisation(
            ArrayList<StatusRegularisation> statusRegularisation ) {
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

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public void setErreurs( Map<String, String> erreurs ) {
        this.erreurs = erreurs;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin( Date dateFin ) {
        this.dateFin = dateFin;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut( Date dateDebut ) {
        this.dateDebut = dateDebut;
    }

    public class RechercheForm {
        private static final String CHAMP_JOURNEE               = "dateJournee";
        private static final String CHAMP_PERIODE               = "datePeriode";
        private static final String CHAMP_CHECK_DATE            = "checkDate";
        private static final String CHAMP_TYPE_ERREUR           = "typeErreur";
        private static final String CHAMP_STATUS_REGULARISATION = "statusRegularisationRecherche";
        private static final String CHAMP_CODE_AGENCE           = "codeAgence";

        private Date                dateJournee;
        private Date                datePeriode;
        private String              checkDate;
        private int                 codeStatusRegularisation;
        private String              codeTypeErreur;
        private Agence              agence;
        private int                 resultat;

        @SuppressWarnings("deprecation")
		public RechercheForm recupererEtVerifierFormulaire(
                HttpServletRequest request ) {

            String dateJourneeString = getValeurChamp( request, CHAMP_JOURNEE );
            String datePeriodeString = getValeurChamp( request, CHAMP_PERIODE );
            String checkDateString = getValeurChamp( request, CHAMP_CHECK_DATE );
            String codeStatusRegularisationString = getValeurChamp( request,
                    CHAMP_STATUS_REGULARISATION );
            String codeTypeErreurString = getValeurChamp( request,
                    CHAMP_TYPE_ERREUR );
            String codeAgence = getValeurChamp( request, CHAMP_CODE_AGENCE );

            if ( checkDateString != null)
            {
            	if (checkDateString.equals( "journee" ) )
            	{
            		try {
            			setDateJournee( validationDate( dateJourneeString ) );
            			setDateDebut( dateJournee );
                        setDateFin( dateJournee );
                        setCheckDate( checkDateString );
            		} catch ( Exception e ) {
            			setErreur( CHAMP_JOURNEE, "Saisir une date valide" );
            			setDateJournee( null );
            		}
            	}
            	else if (checkDateString.equals( "periode" ) )
            	{
            		try {
            			setDatePeriode( validationDate( datePeriodeString ) );
            			setDateDebut( new Date( Calendar.getInstance().get(
                                Calendar.YEAR ) - 1900, 0, 1 ) );
                        setDateFin( datePeriode );
                        setCheckDate( checkDateString );
            		} catch ( Exception e ) {
            			setErreur( CHAMP_PERIODE, "Saisir une date valide" );
            			setDatePeriode( null );
            		}
            	}
            } else
            {
            	setErreur(CHAMP_CHECK_DATE, "Sélection invalide");
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

            try {
                validationCodeAgence( codeAgence );
                setAgence( AgenceDAO.selectByCode( codeAgence ) );
            } catch ( Exception e ) {
                setErreur( CHAMP_CODE_AGENCE, e.getMessage() );
                setAgence( null );
            }

            if ( erreurs.isEmpty() ) {
                setResultat( SUCCES );
            } else {
                setResultat( ECHEC );
            }

            return this;
        }

        private String getValeurChamp( HttpServletRequest request,
                String nomChamp ) {
            String valeur = request.getParameter( nomChamp );
            if ( valeur == null || valeur.trim().length() == 0 ) {
                return null;
            } else {
                return valeur.trim();
            }
        }

        /* Validation des champs */

        private void validationTypeErreur( String codeTypeErreurString )
                throws Exception {
            if ( codeTypeErreurString != null ) {
                if ( codeTypeErreurString.equals( "E" )
                        || codeTypeErreurString.equals( "D" ) )
                    setCodeTypeErreur( codeTypeErreurString );
                else
                    throw new Exception( "Type d'erreur inconnu" );
            }
        }

        private void validationCodeStatus( String codeStatusRegularisationString )
                throws Exception {
            if ( codeStatusRegularisationString != null ) {
                try {
                    setCodeStatusRegularisation( Integer
                            .parseInt( codeStatusRegularisationString ) );
                } catch ( NumberFormatException e ) {
                    e.printStackTrace();
                    throw new Exception( "Status de regularisation inconnu" );
                }
                if ( codeStatusRegularisation < 0
                        || codeStatusRegularisation > 2 )
                    throw new Exception( "Status de regularisation inconnu" );
            }
            setCodeStatusRegularisation( -1 );
        }

/*        @SuppressWarnings( "deprecation" )
        private void validationCheckDate( String checkDate ) throws Exception {
            if ( checkDate != null ) {
                if ( checkDate.equals( "journee" ) ) {
                    setDateDebut( dateJournee );
                    setDateFin( dateJournee );
                    setCheckDate( checkDate );
                } else if ( checkDate.equals( "periode" ) ) {
                    setDateDebut( new Date( Calendar.getInstance().get(
                            Calendar.YEAR ) - 1900, 0, 1 ) );
                    setDateFin( datePeriode );
                    setCheckDate( checkDate );
                }
            } else
                throw new Exception( "Période de recherche inconnue" );

        }
*/
        private void validationCodeAgence( String codeAgence ) throws Exception {
            if ( codeAgence != null ) {
                boolean agenceExists;
                agenceExists = AgenceDAO.existingByCode( codeAgence );
                if ( !agenceExists ) {
                    throw new Exception( "Code agence inconnu" );
                }
            }
        }

        private Date validationDate( String dateString ) throws Exception {
            if ( dateString != null )
                try {
                    return new SimpleDateFormat( "dd/MM/yyyy" ).parse( dateString );
                } catch ( ParseException e ) {
                    e.printStackTrace();
                    throw new Exception( "Merci de saisir une date valide." );
                }
            return null;
        }

        /* Getters and Setters */

        private void setErreur( String champ, String message ) {
            erreurs.put( champ, message );
        }

        public Date getDateJournee() {
            return dateJournee;
        }

        public void setDateJournee( Date dateJournee ) {
            this.dateJournee = dateJournee;
        }

        public Date getDatePeriode() {
            return datePeriode;
        }

        public void setDatePeriode( Date datePeriode ) {
            this.datePeriode = datePeriode;
        }

        public void setAgence( Agence agence ) {
            this.agence = agence;
        }

        public Agence getAgence() {
            return agence;
        }

        public String getCheckDate() {
            return checkDate;
        }

        public void setCheckDate( String checkDate ) {
            this.checkDate = checkDate;
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
