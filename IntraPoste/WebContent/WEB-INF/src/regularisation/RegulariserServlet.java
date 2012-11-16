package regularisation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bdd.ErreurCaisseDAO;

/**
 * Servlet implementation class RegulariserServlet
 */
public class RegulariserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int               erreurCaisseId;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegulariserServlet() {
        super();
        erreurCaisseId = -1;
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        getParameters( request );

        if ( ErreurCaisseDAO.selectById( erreurCaisseId ) != null )
            // TODO: Verifier les autres champs puis regulariser
            this.getServletContext().setAttribute( "this", this );
        this.getServletContext().getRequestDispatcher( "/WEB-INF/regularisation/regulariser.jsp" )
                .forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        // TODO Auto-generated constructor stub
    }

    private void getParameters( HttpServletRequest request ) {
        erreurCaisseId = -1;
        if ( request.getParameter( "erreurCaisseId" ) != null && !request.getParameter( "erreurCaisseId" ).equals( "" ) )
            erreurCaisseId = Integer.parseInt( request.getParameter( "erreurCaisseId" ) );

    }

    /**
     * @return the erreurCaisseId
     */
    public int getErreurCaisseId() {
        return erreurCaisseId;
    }

    /**
     * @param erreurCaisseId
     *            the erreurCaisseId to set
     */
    public void setErreurCaisseId( int erreurCaisseId ) {
        this.erreurCaisseId = erreurCaisseId;
    }

}
