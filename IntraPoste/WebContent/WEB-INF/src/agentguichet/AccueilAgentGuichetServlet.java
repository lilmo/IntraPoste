package agentguichet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bdd.ErreurCaisseDAO;
import bdd.StatusRegularisationDAO;
import bdd.TypeErreurDAO;

import metier.ErreurCaisse;
import metier.StatusRegularisation;
import metier.TypeErreur;

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
        if ( request.getParameter( "typeErreur" ) != null )
            codeTypeErreurRecherche = (String) request.getParameter( "typeErreur" ).toString();
        if ( request.getParameter( "statusRegularisationRecherche" ) != null )
            codeStatusRegularisationRecherche = Integer.parseInt( request
                    .getParameter( "statusRegularisationRecherche" ) );
    }
}
