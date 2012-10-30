/***********************************************************************
 * Module:  TypeAgent.java
 * Author:  Morgane
 * Purpose: Defines the Class TypeAgent
 ***********************************************************************/

package metier;

public class TypeAgent {
	private String codeTypeAgent;
	private String nomTypeAgent;

	public TypeAgent(String codeTypeAgent, String nomTypeAgent) {
		super();
		this.codeTypeAgent = codeTypeAgent;
		this.nomTypeAgent = nomTypeAgent;
	}

	/**
	 * @return the codeTypeAgent
	 */
	public String getCodeTypeAgent() {
		return codeTypeAgent;
	}

	/**
	 * @param codeTypeAgent
	 *            the codeTypeAgent to set
	 */
	public void setCodeTypeAgent(String codeTypeAgent) {
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