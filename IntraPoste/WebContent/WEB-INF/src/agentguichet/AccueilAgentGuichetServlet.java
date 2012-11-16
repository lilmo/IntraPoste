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
    private static final long               serialVersionUID                  = 1L;
    private ArrayList<ErreurCaisse>         erreurs                           = null;
    private ArrayList<TypeErreur>           typesErreur                       = null;
    private ArrayList<StatusRegularisation> statusRegularisation              = null;

    private Date                            dateDebut                         = null;
    private Date                            dateFin                           = null;
    private int                             codeStatusRegularisationRecherche = -1;
    private String                          codeTypeErreurRecherche           = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilAgentGuichetServlet() {
        super();
        // TODO Auto-generated constructor stub
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
            this.getServletContext().setAttribute( "erreurs", erreurs );

            typesErreur = TypeErreurDAO.selectAll();
            this.getServletContext().setAttribute( "typesErreur", typesErreur );

            statusRegularisation = StatusRegularisationDAO.selectAll();
            this.getServletContext().setAttribute( "statusRegularisation", statusRegularisation );
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
            codeTypeErreurRecherche = (String) request.getParameter( "typeErreur" ).toString();
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
}
