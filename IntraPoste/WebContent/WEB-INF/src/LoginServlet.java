
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPageServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.setContentType("text/html;charset=UTF-8");
		// PrintWriter out = response.getWriter();
		// try {
		// out.println("<html><body><p>Hello Monsieur B</p></body></html>");
		// } finally {
		// out.close();
		// }
		
		String paramAuteur = request.getParameter("auteur");
		// Si on appelle la servlet avec "?auteur=Coyote", on verra Coyote
		// s'afficher après OK !
		String message = "Transmission de variables : OK !<br>paramAuteur : " + paramAuteur;
		request.setAttribute("test", message);
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
