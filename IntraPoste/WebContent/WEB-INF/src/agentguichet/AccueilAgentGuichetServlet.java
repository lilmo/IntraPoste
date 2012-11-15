package agentguichet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bdd.ErreurCaisseDAO;

import metier.ErreurCaisse;

/**
 * Servlet implementation class AccueilAgentGuichetServlet
 */
public class AccueilAgentGuichetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<ErreurCaisse> erreurs = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilAgentGuichetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codeAgent = "TOTO_C";
		try {
			erreurs = ErreurCaisseDAO.selectErreursCaisseByAgent(codeAgent);
			this.getServletContext().setAttribute("erreurs", erreurs);
			this.getServletContext().getRequestDispatcher("/WEB-INF/agent-guichet/accueil-agent-guichet.jsp")
			.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
	public void setErreurs(ArrayList<ErreurCaisse> erreurs) {
		this.erreurs = erreurs;
	}

	
	
}
