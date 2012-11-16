package regularisation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Agent;
import metier.AgentGuichet;
import metier.ErreurCaisse;
import metier.MotifRegularisation;

import bdd.AgentDAO;
import bdd.ErreurCaisseDAO;
import bdd.MotifRegularisationDAO;

/**
 * Servlet implementation class RegulariserServlet
 */
public class RegulariserServlet extends HttpServlet {
    private static final long              serialVersionUID = 1L;
    private int                            erreurCaisseId;
    private ArrayList<MotifRegularisation> motifs;
    private float                            reste;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegulariserServlet() {
        super();
        setErreurCaisseId( -1 );
        setMotifs( null );
        setReste( -1 );
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        getParameters( request );
        try {
            setMotifs();
        } catch ( SQLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if ( ErreurCaisseDAO.selectById( erreurCaisseId ) != null )
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
        int montant = Integer.parseInt( request.getParameter( "montant" ) );
        int motif = Integer.parseInt( request.getParameter( "motif" ) );
        String autreMotif = request.getParameter( "autreMotif" );

        if ( checkFormParameters( montant, motif, autreMotif ) )
        {
            MotifRegularisation motifEnBase;
            try {
                motifEnBase = MotifRegularisationDAO.selectByCode( motif );

                if ( motifEnBase == null )
                {
                    MotifRegularisationDAO.insert( autreMotif );
                    motifEnBase = MotifRegularisationDAO.selectByNom( autreMotif );
                }

                // TODO: récupérer l'agent en session
                AgentGuichet agentGuichet = (AgentGuichet) AgentDAO.selectByCode( "TOTO_C" );
                int resultat = agentGuichet.regulariserErreur( erreurCaisseId, montant, agentGuichet.getCodeAgent(),
                        motifEnBase );
                // TODO: afficher un succes ou une erreur
            } catch ( SQLException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private boolean checkFormParameters( int montant, int motif, String autreMotif ) {
        // TODO A completer
        return true;
    }

    private void getParameters( HttpServletRequest request ) {
        setErreurCaisseId( -1 );
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

    public ArrayList<MotifRegularisation> getMotifs() {
        return motifs;
    }

    public void setMotifs( ArrayList<MotifRegularisation> motifs ) {
        this.motifs = motifs;
    }

    public void setMotifs() throws SQLException {
        this.motifs = new ArrayList<>();
        motifs.add( MotifRegularisationDAO.selectByNom( "PRISE EN RECETTE" ) );
        motifs.add( MotifRegularisationDAO.selectByNom( "REMBOURSEE A L UTILISATEUR" ) );
        motifs.add( MotifRegularisationDAO.selectByNom( "ERREUR DE COMPTABILITE RETROUVEE" ) );
        motifs.add( MotifRegularisationDAO.selectByNom( "REJET REGULARISE" ) );
    }

    public float getReste() throws SQLException {
        ErreurCaisse erreur = ErreurCaisseDAO.selectById( erreurCaisseId );
        if ( erreur != null )
            setReste( erreur.resteARegulariser() );
        return reste;
    }

    public void setReste( float reste ) {
        this.reste = reste;
    }
}
