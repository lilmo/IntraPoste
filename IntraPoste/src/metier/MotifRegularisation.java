/***********************************************************************
 * Module:  MotifRegularisation.java
 * Author:  Morgane
 * Purpose: Defines the Class MotifRegularisation
 ***********************************************************************/

package metier;

import tools.Casse;

public class MotifRegularisation {
    private int    codeMotifRegularisation;
    private String nomMotifRegularisation;

    public MotifRegularisation( int codeMotifRegularisation,
            String nomMotifRegularisation ) {
        super();
        this.codeMotifRegularisation = codeMotifRegularisation;
        this.nomMotifRegularisation = Casse.toTitleCase( nomMotifRegularisation );
    }

    /**
     * @return the codeMotifRegularisation
     */
    public int getCodeMotifRegularisation() {
        return codeMotifRegularisation;
    }

    /**
     * @param codeMotifRegularisation
     *            the codeMotifRegularisation to set
     */
    public void setCodeMotifRegularisation( int codeMotifRegularisation ) {
        this.codeMotifRegularisation = codeMotifRegularisation;
    }

    /**
     * @return the nomMotifRegularisation
     */
    public String getNomMotifRegularisation() {
        return nomMotifRegularisation;
    }

    /**
     * @param nomMotifRegularisation
     *            the nomMotifRegularisation to set
     */
    public void setNomMotifRegularisation( String nomMotifRegularisation ) {
        this.nomMotifRegularisation = nomMotifRegularisation;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MotifRegularisation [codeMotifRegularisation="
                + codeMotifRegularisation + ", nomMotifRegularisation="
                + nomMotifRegularisation + "]";
    }

}