package regularisation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.ErreursCaisseRegularisation;
import bdd.ErreurCaisseDAO;
import bdd.ErreurCaisseRegularisationDAO;

/**
 * Servlet implementation class ListeRegularisationServlet
 */
public class ListeRegularisationsServlet extends HttpServlet {
    private static final long                      serialVersionUID = 1L;
    private int                                    erreurCaisseId;
    private int                                    codeStatusRegularisation;

    private String                                 erreur;

    private ArrayList<ErreursCaisseRegularisation> regularisations;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeRegularisationsServlet() {
        super();
        erreurCaisseId = -1;
        codeStatusRegularisation = -1;
        setRegularisations( null );
        setErreur( null );
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        getParameters( request );

        if ( ErreurCaisseDAO.selectById( erreurCaisseId ) != null )
        {
            try {
                setRegularisations( ErreurCaisseRegularisationDAO.selectByErreurCaisse( erreurCaisseId ) );
                this.getServletContext().setAttribute( "this", this );
            } catch ( SQLException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                setErreur( "La base de donnee a rencontre un probleme. Recherche abandonee." );
            }
        }

        this.getServletContext().getRequestDispatcher( "/WEB-INF/regularisation/liste-regularisations.jsp" )
                .forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
    }

    private void getParameters( HttpServletRequest request ) {
        erreurCaisseId = -1;
        codeStatusRegularisation = -1;
        setErreur( null );
        if ( request.getParameter( "erreurCaisseId" ) != null && !request.getParameter( "erreurCaisseId" ).equals( "" ) )
            try
            {
                erreurCaisseId = Integer.parseInt( request.getParameter( "erreurCaisseId" ) );
            } catch ( NumberFormatException e ) {
                setErreur( "Le numero d'erreur n'existe pas." );
            }
        if ( request.getParameter( "codeStatusRegularisation" ) != null
                && !request.getParameter( "codeStatusRegularisation" ).equals( "" ) )
            try {
                codeStatusRegularisation = Integer.parseInt( request.getParameter( "codeStatusRegularisation" ) );
                setErreur( "Le statut de regularisation n'existe pas." );
            } catch ( NumberFormatException e ) {
                // TODO: handle exception
            }
    }

    public ArrayList<ErreursCaisseRegularisation> getRegularisations() {
        return regularisations;
    }

    public void setRegularisations( ArrayList<ErreursCaisseRegularisation> regularisations ) {
        this.regularisations = regularisations;
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

    /**
     * @return the codeStatusRegularisation
     */
    public int getCodeStatusRegularisation() {
        return codeStatusRegularisation;
    }

    /**
     * @param codeStatusRegularisation
     *            the codeStatusRegularisation to set
     */
    public void setCodeStatusRegularisation( int codeStatusRegularisation ) {
        this.codeStatusRegularisation = codeStatusRegularisation;
    }

    public String getErreur() {
        return erreur;
    }

    public void setErreur( String erreur ) {
        this.erreur = erreur;
    }

}
