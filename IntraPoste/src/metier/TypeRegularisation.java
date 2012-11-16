/***********************************************************************
 * Module:  TypeRegularisation.java
 * Author:  Morgane
 * Purpose: Defines the Class TypeRegularisation
 ***********************************************************************/

package metier;

import tools.Casse;

public class TypeRegularisation {
    private int    codeTypeRegularisation;
    private String nomTypeRegularisation;

    public TypeRegularisation( int codeTypeRegularisation,
            String nomTypeRegularisation ) {
        super();
        this.codeTypeRegularisation = codeTypeRegularisation;
        this.nomTypeRegularisation = Casse.toTitleCase( nomTypeRegularisation );
    }

    /**
     * @return the codeTypeRegularisation
     */
    public int getCodeTypeRegularisation() {
        return codeTypeRegularisation;
    }

    /**
     * @param codeTypeRegularisation
     *            the codeTypeRegularisation to set
     */
    public void setCodeTypeRegularisation( int codeTypeRegularisation ) {
        this.codeTypeRegularisation = codeTypeRegularisation;
    }

    /**
     * @return the nomTypeRegularisation
     */
    public String getNomTypeRegularisation() {
        return nomTypeRegularisation;
    }

    /**
     * @param nomTypeRegularisation
     *            the nomTypeRegularisation to set
     */
    public void setNomTypeRegularisation( String nomTypeRegularisation ) {
        this.nomTypeRegularisation = nomTypeRegularisation;
    }

}