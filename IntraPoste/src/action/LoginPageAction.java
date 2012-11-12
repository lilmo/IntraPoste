package action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginPageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String login;
	private String password;

	@Override
	public String execute() throws Exception {

		return "guichet";
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
