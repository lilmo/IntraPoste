package regularisation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Agent;
import metier.AgentComptable;
import metier.AgentGuichet;
import metier.ErreurCaisse;
import metier.MotifRegularisation;
import tools.Check;
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
    private float                          reste;
    private String                         erreur;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegulariserServlet() {
        super();
        setErreurCaisseId( -1 );
        setMotifs( null );
        setReste( -1 );
        setErreur( null );
    }

    /**
     * @throws IOException
     * @throws ServletException
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        boolean redirect = false;
        if ( Check.checkAgent( request ) )
        {
            getParameters( request );
            setMotifs();

            if ( ErreurCaisseDAO.selectById( erreurCaisseId ) == null )
                setErreur( "Le numero d'erreur n'existe pas." );
        }
        else
            redirect = true;
        if ( redirect )
            response.sendRedirect( "LoginServlet" );
        else
        {
            this.getServletContext().setAttribute( "this", this );
            this.getServletContext().getRequestDispatcher( "/WEB-INF/regularisation/regulariser.jsp" )
                    .forward( request, response );
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {

        String pageRetour = "/RegulariserServlet";

        if ( Check.checkAgent( request ) )
        {
            Agent agent = AgentDAO.selectByCode( (String) request.getSession()
                    .getAttribute( "codeAgent" ) );
            AgentComptable agentComptable = null;
            AgentGuichet agentGuichet = null;
            if ( Check.checkTypeAgent( "comptable", agent ) )
                agentComptable = (AgentComptable) agent;
            else if ( Check.checkTypeAgent( "guichet", agent ) )
                agentGuichet = (AgentGuichet) agent;

            getParameters( request );
            setErreur( null );
            float montant = -1;
            int motif = -1;
            try {
                montant = Float.valueOf( request.getParameter( "montant" ).trim() ).floatValue();
            } catch ( NumberFormatException e )
            {
                setErreur( "Le montant doit etre un chiffre." );
            }
            try {
                motif = Integer.parseInt( request.getParameter( "motif" ) );
            } catch ( NumberFormatException e )
            {
                setErreur( "Motif invalide" );
            }
            String autreMotif = request.getParameter( "autreMotif" );

            MotifRegularisation motifEnBase;
            try {
                motifEnBase = MotifRegularisationDAO.selectByCode( motif );

                if ( motifEnBase == null )
                {
                    MotifRegularisationDAO.insert( autreMotif );
                    motifEnBase = MotifRegularisationDAO.selectByNom( autreMotif );
                }
                int resultat = -1;
                if ( agentComptable != null )
                    resultat = agentComptable.regulariserErreur( erreurCaisseId, montant, agentComptable.getCodeAgent(),
                            motifEnBase );
                else if ( agentGuichet != null )
                    resultat = agentGuichet.regulariserErreur( erreurCaisseId, montant, agentGuichet.getCodeAgent(),
                            motifEnBase );
                switch ( resultat ) {
                case 1:
                    setErreur( "Cette erreur a deja ete regularisee" );
                    break;
                case 2:
                    setErreur( "Vous n'etes pas autorise a effectuer cette operation" );
                    break;
                case 3:
                    setErreur( "La base de donnee a rencontre un probleme. Operation abandonee." );
                    break;
                }
            } catch ( SQLException e ) {
                e.printStackTrace();
                setErreur( "La base de donnee a rencontre un probleme. Operation abandonee." );
            }

            if ( erreur == null || erreur.isEmpty() )
                pageRetour = "/AccueilAgentGuichetServlet";
        }
        this.getServletContext().getRequestDispatcher( pageRetour )
                .forward( request, response );
    }

    private void getParameters( HttpServletRequest request ) {
        setErreur( null );
        setErreurCaisseId( -1 );
        if ( request.getParameter( "erreurCaisseId" ) != null && !request.getParameter( "erreurCaisseId" ).equals( "" ) )
            try {
                erreurCaisseId = Integer.parseInt( request.getParameter( "erreurCaisseId" ) );
            } catch ( NumberFormatException e )
            {
                setErreur( "Le numero d'erreur n'existe pas." );
            }

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

    public void setMotifs() {
        this.motifs = new ArrayList<>();
        try {
            motifs.add( MotifRegularisationDAO.selectByNom( "REJET REGULARISE" ) );
            motifs.add( MotifRegularisationDAO.selectByNom( "PRISE EN RECETTE" ) );
            motifs.add( MotifRegularisationDAO.selectByNom( "REMBOURSEE A L UTILISATEUR" ) );
            motifs.add( MotifRegularisationDAO.selectByNom( "ERREUR DE COMPTABILITE RETROUVEE" ) );
        } catch ( SQLException e ) {
            e.printStackTrace();
            setErreur( "La base de donnee a rencontre un probleme. Operation abandonee." );
        }
    }

    public float getReste() {
        ErreurCaisse erreur = ErreurCaisseDAO.selectById( erreurCaisseId );
        if ( erreur != null )
            try {
                setReste( erreur.resteARegulariser() );
            } catch ( SQLException e ) {
                e.printStackTrace();
                setErreur( "La base de donnee a rencontre un probleme. Operation abandonee." );
            }
        return reste;
    }

    public void setReste( float reste ) {
        this.reste = reste;
    }

    public String getErreur() {
        return erreur;
    }

    public void setErreur( String erreur ) {
        this.erreur = erreur;
    }
}
