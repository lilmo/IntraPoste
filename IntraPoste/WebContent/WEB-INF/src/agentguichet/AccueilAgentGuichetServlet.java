package agentguichet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    private ArrayList<ErreurCaisse>         erreursCaisse;
    private ArrayList<TypeErreur>           typesErreurs;
    private ArrayList<StatusRegularisation> statusRegularisation;

    private Date                            dateDebut;
    private Date                            dateFin;
    private int                             codeStatusRegularisationRecherche;
    private String                          codeTypeErreurRecherche;

    private String                          erreur;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilAgentGuichetServlet() {
        super();
        setErreursCaisse( null );
        setTypesErreurs( null );
        setStatusRegularisation( null );
        dateDebut = null;
        dateFin = null;
        codeStatusRegularisationRecherche = -1;
        codeTypeErreurRecherche = null;
        setErreur( null );
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        try {

            if ( getParameters( request ) )
            {
                HttpSession session = request.getSession();
                /* Récupération de l'objet depuis la session */
                AgentGuichet agent = (AgentGuichet) session.getAttribute( "agent" );
                setErreursCaisse( ErreurCaisseDAO.selectErreursCaisseByAgent( agent.getCodeAgent(), dateDebut, dateFin,
                        codeTypeErreurRecherche,
                        codeStatusRegularisationRecherche ) );
                if ( erreursCaisse.isEmpty() )
                {
                    setErreursCaisse( ErreurCaisseDAO.selectAll() );
                    setErreur( "Aucun resultat ne correspond a votre recherche." );
                }
            }
            else
                setErreursCaisse( ErreurCaisseDAO.selectAll() );

            setTypesErreurs( TypeErreurDAO.selectAll() );
            setStatusRegularisation( StatusRegularisationDAO.selectAll() );

            this.getServletContext().setAttribute( "this", this );
        } catch ( SQLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            setErreur( "La base de donnee a rencontre un probleme. Recherche abandonee." );
        } finally {
            this.getServletContext().getRequestDispatcher( "/WEB-INF/agent-guichet/accueil-agent-guichet.jsp" )
                    .forward( request, response );
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        try {

            if ( getParameters( request ) )
            {
                HttpSession session = request.getSession();
                /* Récupération de l'objet depuis la session */
                AgentGuichet agent = (AgentGuichet) session.getAttribute( "agent" );
                setErreursCaisse( ErreurCaisseDAO.selectErreursCaisseByAgent( agent.getCodeAgent(), dateDebut, dateFin,
                        codeTypeErreurRecherche,
                        codeStatusRegularisationRecherche ) );
                if ( erreursCaisse.isEmpty() )
                {
                    setErreursCaisse( ErreurCaisseDAO.selectAll() );
                    setErreur( "Aucun resultat ne correspond a votre recherche." );
                }
            }
            else
                setErreursCaisse( ErreurCaisseDAO.selectAll() );

            setTypesErreurs( TypeErreurDAO.selectAll() );
            setStatusRegularisation( StatusRegularisationDAO.selectAll() );

            this.getServletContext().setAttribute( "this", this );
        } catch ( SQLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            setErreur( "La base de donnee a rencontre un probleme. Recherche abandonee." );
        } finally {
            this.getServletContext().getRequestDispatcher( "/WEB-INF/agent-guichet/accueil-agent-guichet.jsp" )
                    .forward( request, response );
        }
    }

    private boolean getParameters( HttpServletRequest request )
    {
        codeStatusRegularisationRecherche = -1;
        codeTypeErreurRecherche = null;
        dateDebut = null;
        dateFin = null;
        setErreur( null );
        if ( request.getParameter( "typeErreur" ) != null && !request.getParameter( "typeErreur" ).equals( "" ) )
            codeTypeErreurRecherche = (String) request.getParameter( "typeErreur" );
        if ( request.getParameter( "statusRegularisationRecherche" ) != null
                && !request.getParameter( "statusRegularisationRecherche" ).equals( "" ) )
            codeStatusRegularisationRecherche = Integer.parseInt( request
                    .getParameter( "statusRegularisationRecherche" ) );
        if ( request.getParameter( "dateDebut" ) != null && !request.getParameter( "dateDebut" ).equals( "" ) )
            try {
                dateDebut = new SimpleDateFormat( "dd/MM/yyyy" ).parse( request.getParameter( "dateDebut" ) );
            } catch ( ParseException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                setErreur( "La date de debut doit etre au format \"jj/mm/aaaa\"." );
            }
        if ( request.getParameter( "dateFin" ) != null && !request.getParameter( "dateFin" ).equals( "" ) )
            try {
                dateFin = new SimpleDateFormat( "dd/MM/yyyy" ).parse( request.getParameter( "dateFin" ) );
            } catch ( ParseException e ) {
                // TODO Auto-generated catch block
                setErreur( "La date de fin doit etre au format \"jj/mm/aaaa\"." );
                e.printStackTrace();
            }
        if ( codeStatusRegularisationRecherche == -1 && codeTypeErreurRecherche == null && dateDebut == null
                && dateFin == null )
            return false;
        return true;
    }

    /**
     * @return the erreurs
     */
    public ArrayList<ErreurCaisse> getErreursCaisse() {
        return erreursCaisse;
    }

    /**
     * @param erreurs
     *            the erreurs to set
     */
    public void setErreursCaisse( ArrayList<ErreurCaisse> erreurs ) {
        this.erreursCaisse = erreurs;
    }

    /**
     * @return the codeStatusRegularisationRecherche
     */
    public int getCodeStatusRegularisationRecherche() {
        return codeStatusRegularisationRecherche;
    }

    /**
     * @param codeStatusRegularisationRecherche
     *            the codeStatusRegularisationRecherche to set
     */
    public void setCodeStatusRegularisationRecherche( int codeStatusRegularisationRecherche ) {
        this.codeStatusRegularisationRecherche = codeStatusRegularisationRecherche;
    }

    /**
     * @return the codeTypeErreurRecherche
     */
    public String getCodeTypeErreurRecherche() {
        return codeTypeErreurRecherche;
    }

    /**
     * @param codeTypeErreurRecherche
     *            the codeTypeErreurRecherche to set
     */
    public void setCodeTypeErreurRecherche( String codeTypeErreurRecherche ) {
        this.codeTypeErreurRecherche = codeTypeErreurRecherche;
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

    public String getErreur() {
        return erreur;
    }

    public void setErreur( String erreur ) {
        this.erreur = erreur;
    }
}
