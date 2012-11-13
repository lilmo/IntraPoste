/***********************************************************************
 * Module:  TypeAgent.java
 * Author:  Morgane
 * Purpose: Defines the Class TypeAgent
 ***********************************************************************/

package metier;

public class TypeAgent {
	private int codeTypeAgent;
	private String nomTypeAgent;

	public TypeAgent(int codeTypeAgent, String nomTypeAgent) {
		super();
		this.codeTypeAgent = codeTypeAgent;
		this.nomTypeAgent = nomTypeAgent;
	}

	/**
	 * @return the codeTypeAgent
	 */
	public int getCodeTypeAgent() {
		return codeTypeAgent;
	}

	/**
	 * @param codeTypeAgent
	 *            the codeTypeAgent to set
	 */
	public void setCodeTypeAgent(int codeTypeAgent) {
		this.codeTypeAgent = codeTypeAgent;
	}

	/**
	 * @return the nomTypeAgent
	 */
	public String getNomTypeAgent() {
		return nomTypeAgent;
	}

	/**
	 * @param nomTypeAgent
	 *            the nomTypeAgent to set
	 */
	public void setNomTypeAgent(String nomTypeAgent) {
		this.nomTypeAgent = nomTypeAgent;
	}

}