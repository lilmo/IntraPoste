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
    private ArrayList<ErreurCaisse>         erreurs;
    private ArrayList<TypeErreur>           typesErreurs;
    private ArrayList<StatusRegularisation> statusRegularisation;

    private Date                            dateDebut;
    private Date                            dateFin;
    private int                             codeStatusRegularisationRecherche;
    private String                          codeTypeErreurRecherche;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilAgentGuichetServlet() {
        super();
        erreurs = null;
        setTypesErreurs( null );
        setStatusRegularisation( null );
        dateDebut = null;
        dateFin = null;
        codeStatusRegularisationRecherche = -1;
        codeTypeErreurRecherche = null;
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        // TODO: recuperer le code agent en session
        String codeAgent = "TOTO_C";
        try {

            getParameters( request );

            erreurs = ErreurCaisseDAO.selectErreursCaisseByAgent( codeAgent, dateDebut, dateFin,
                    codeTypeErreurRecherche,
                    codeStatusRegularisationRecherche );
            if ( !erreurs.isEmpty() )
                ErreurCaisseDAO.selectAll();

            setTypesErreurs( TypeErreurDAO.selectAll() );
            this.getServletContext().setAttribute( "this", this );

            setStatusRegularisation( StatusRegularisationDAO.selectAll() );
        } catch ( SQLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
        // TODO Auto-generated method stub
    }

    private void getParameters( HttpServletRequest request )
    {
        codeStatusRegularisationRecherche = -1;
        codeTypeErreurRecherche = null;
        dateDebut = null;
        dateFin = null;
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
            }
        if ( request.getParameter( "dateFin" ) != null && !request.getParameter( "dateFin" ).equals( "" ) )
            try {
                dateFin = new SimpleDateFormat( "dd/MM/yyyy" ).parse( request.getParameter( "dateFin" ) );
            } catch ( ParseException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

    /**
     * @return the erreurs
     */
    public ArrayList<ErreurCaisse> getErreurs() {
        return erreurs;
    }

    /**
     * @param erreurs the erreurs to set
     */
    public void setErreurs( ArrayList<ErreurCaisse> erreurs ) {
        this.erreurs = erreurs;
    }

    /**
     * @return the codeStatusRegularisationRecherche
     */
    public int getCodeStatusRegularisationRecherche() {
        return codeStatusRegularisationRecherche;
    }

    /**
     * @param codeStatusRegularisationRecherche the codeStatusRegularisationRecherche to set
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
     * @param codeTypeErreurRecherche the codeTypeErreurRecherche to set
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
}
