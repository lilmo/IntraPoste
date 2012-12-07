import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Agent;
import metier.Main;
import tools.MD5;
import bdd.AgentDAO;

/**
 * Servlet implementation class LoginPageServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Agent             agent;
    private String            motDePasse;
    private String            erreur;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        setMotDePasse( null );
        setAgent( null );
        setErreur( null );
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException {
        if ( request.getParameter( "init" ) != null )
        {
            try {
                Main.initFromServlet();
            } catch ( SQLException | InterruptedException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        this.getServletContext().setAttribute( "this", this );
        this.getServletContext().getRequestDispatcher( "/WEB-INF/index.jsp" )
                .forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException {
        String pageRetour = null;
        if ( checkIdentification( request ) ) {
            /* Création ou récupération de la session */
            HttpSession session = request.getSession();

            /* Mise en session d'une chaîne de caractères */
            session.setAttribute( "codeAgent", agent.getCodeAgent() );
            this.getServletContext().setAttribute( "this", this );

            switch ( agent.getTypeAgent().getCodeTypeAgent() ) {
            case 0:
                pageRetour = "AccueilAgentDirectionServlet";
                break;
            case 1:
                pageRetour = "AccueilAgentComptableServlet";
                break;
            case 2:
                pageRetour = "AccueilAgentGuichetServlet";
                break;
            default:

                break;
            }

            // this.getServletContext().getRequestDispatcher( pageRetour
            // ).forward( request, response );
            response.sendRedirect( pageRetour );
        }
        else
            response.sendRedirect( "LoginServlet" );
    }

    private Boolean checkIdentification( HttpServletRequest request )
    {
        setErreur( null );
        agent = AgentDAO.selectByCode( request.getParameter( "codeAgent" ) );
        motDePasse = MD5.encode( request.getParameter( "motDePasse" ) );
        if ( agent != null )
            if ( motDePasse.equals( agent.getMotDePasse() ) )
                return true;
        setErreur( "Erreur d'authentification" );
        return false;
    }

    /**
     * @return the agent
     */
    public Agent getAgent() {
        return agent;
    }

    /**
     * @param agent
     *            the agent to set
     */
    public void setAgent( Agent agent ) {
        this.agent = agent;
    }

    /**
     * @return the motDePasse
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * @param motDePasse
     *            the motDePasse to set
     */
    public void setMotDePasse( String motDePasse ) {
        this.motDePasse = motDePasse;
    }

    public String getErreur() {
        return erreur;
    }

    public void setErreur( String erreur ) {
        this.erreur = erreur;
    }

}
