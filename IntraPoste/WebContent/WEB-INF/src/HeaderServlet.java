
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Agent;

import bdd.AgentDAO;

/**
 * Servlet implementation class HeaderServlet
 */
public class HeaderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        Agent a = AgentDAO.selectByCode( (String) request.getSession().getAttribute( "codeAgent" ) );
        this.getServletContext().setAttribute( "typeAgent", a.getTypeAgent().getCodeTypeAgent());
        this.getServletContext().setAttribute( "nomAgent", a.getNom());
        this.getServletContext().setAttribute( "prenomAgent", a.getPrenom());
        this.getServletContext().getRequestDispatcher( "/WEB-INF/header.jsp" )
                .forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        doGet( request, response );
    }

}
