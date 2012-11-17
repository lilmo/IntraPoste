package regularisation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Agent;
import metier.ErreursCaisseRegularisation;
import bdd.ErreurCaisseDAO;
import bdd.ErreurCaisseRegularisationDAO;

/**
 * Servlet implementation class ListeRegularisationServlet
 */
public class ListeRegularisationsServlet extends HttpServlet {
    private static final long                      serialVersionUID    = 1L;

    private static final String                    PARAM_ERREUR_CAISSE = "erreurCaisseId";
    private static final String                    PARAM_CODE_STATUS   = "codeStatusRegularisation";

    private int                                    erreurCaisseId;
    private int                                    codeStatusRegularisation;

    private ArrayList<String>                      erreurs;

    private ArrayList<ErreursCaisseRegularisation> regularisations;
    private Agent                                  agent;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeRegularisationsServlet() {
        super();
        erreurCaisseId = -1;
        codeStatusRegularisation = -1;
        setRegularisations( null );
        setErreurs( null );
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {

        HttpSession session = request.getSession();
        setAgent( (Agent) session.getAttribute( "agent" ) );

        getParameters( request );

        if ( ErreurCaisseDAO.selectById( erreurCaisseId ) != null )
        {
            try {
                setRegularisations( ErreurCaisseRegularisationDAO.selectByErreurCaisse( erreurCaisseId ) );
            } catch ( SQLException e ) {
                e.printStackTrace();
                erreurs.add( "La base de donnee a rencontre un probleme. Recherche abandonee." );
            } finally {
                this.getServletContext().setAttribute( "this", this );
                this.getServletContext().getRequestDispatcher( "/WEB-INF/regularisation/liste-regularisations.jsp" )
                        .forward( request, response );
            }
        }

    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
    }

    private void getParameters( HttpServletRequest request ) {

        String codeStatusString = getValeurParametre( request, PARAM_CODE_STATUS );
        try {
            validationCodeStatus( codeStatusString );
        } catch ( Exception e1 ) {
            e1.printStackTrace();
            erreurs.add( e1.getMessage() );
        }

        String erreurCaisseString = getValeurParametre( request, PARAM_ERREUR_CAISSE );
        try {
            validationErreurCaisse( erreurCaisseString );
        } catch ( Exception e1 ) {
            e1.printStackTrace();
            erreurs.add( e1.getMessage() );
        }

    }

    private String getValeurParametre( HttpServletRequest request, String nomParametre ) {
        String valeur = request.getParameter( nomParametre );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }

    private void validationErreurCaisse( String erreurCaisseString ) throws Exception {
        if ( erreurCaisseString != null )
        {
            try
            {
                setErreurCaisseId( Integer.parseInt( erreurCaisseString ) );
                if ( ErreurCaisseDAO.selectById( erreurCaisseId ) == null )
                    throw new Exception( "Le numero d'erreur n'existe pas." );
            } catch ( NumberFormatException e ) {
                setErreurCaisseId( -1 );
                throw new Exception( "Numero d'erreur invalide" );
            }
        }
    }

    private void validationCodeStatus( String codeStatusRegularisationString ) throws Exception {
        if ( codeStatusRegularisationString != null )
        {
            try {
                setCodeStatusRegularisation( Integer.parseInt( codeStatusRegularisationString ) );
            } catch ( NumberFormatException e ) {
                e.printStackTrace();
                throw new Exception( "Status de regularisation invalide" );
            }
            if ( codeStatusRegularisation < 0 || codeStatusRegularisation > 2 )
                throw new Exception( "Status de regularisation invalide" );
        }
    }

    public ArrayList<ErreursCaisseRegularisation> getRegularisations() {
        return regularisations;
    }

    public void setRegularisations( ArrayList<ErreursCaisseRegularisation> regularisations ) {
        this.regularisations = regularisations;
    }

    public int getErreurCaisseId() {
        return erreurCaisseId;
    }

    public void setErreurCaisseId( int erreurCaisseId ) {
        this.erreurCaisseId = erreurCaisseId;
    }

    public int getCodeStatusRegularisation() {
        return codeStatusRegularisation;
    }

    public void setCodeStatusRegularisation( int codeStatusRegularisation ) {
        this.codeStatusRegularisation = codeStatusRegularisation;
    }

    public ArrayList<String> getErreurs() {
        return erreurs;
    }

    public void setErreurs( ArrayList<String> erreur ) {
        this.erreurs = erreur;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent( Agent agent ) {
        this.agent = agent;
    }

}
