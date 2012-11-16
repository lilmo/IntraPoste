/***********************************************************************
 * Module:  ErreursCaisseRegularisation.java
 * Author:  Morgane
 * Purpose: Defines the Class ErreursCaisseRegularisation
 ***********************************************************************/

package metier;

import java.sql.SQLException;
import java.sql.Timestamp;

import bdd.AgentDAO;
import bdd.MotifRegularisationDAO;
import bdd.TypeRegularisationDAO;

public class ErreursCaisseRegularisation {
    private java.sql.Timestamp  timestamp;
    private Agent               agentRegularisateur;
    private MotifRegularisation motifRegularisation;
    private int                 erreurCaisseId;
    private TypeRegularisation  typeRegularisation;
    private float               montantRegularisation;

    public ErreursCaisseRegularisation( Timestamp timestamp,
            Agent agentRegularisateur, MotifRegularisation motifRegularisation,
            int erreurCaisseId, TypeRegularisation typeRegularisation,
            float montantRegularisation ) {
        this.timestamp = timestamp;
        this.agentRegularisateur = agentRegularisateur;
        this.motifRegularisation = motifRegularisation;
        this.erreurCaisseId = erreurCaisseId;
        this.typeRegularisation = typeRegularisation;
        this.montantRegularisation = montantRegularisation;
    }

    public ErreursCaisseRegularisation( Timestamp timestamp, String codeAgentRegularisateur, int codeMotifRegularisation, int erreurCaisseId, int codeTypeRegularisation,
            float montantRegularisation ) throws SQLException {
        // TODO Auto-generated constructor stub
        this.timestamp = timestamp;
        this.agentRegularisateur = AgentDAO.selectByCode( codeAgentRegularisateur );
        this.motifRegularisation = MotifRegularisationDAO.selectByCode( codeMotifRegularisation );
        this.erreurCaisseId = erreurCaisseId;
        this.typeRegularisation = TypeRegularisationDAO.selectByCode( codeTypeRegularisation );
        this.montantRegularisation = montantRegularisation;
    }

    /**
     * @return the timestamp
     */
    public java.sql.Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp
     *            the timestamp to set
     */
    public void setTimestamp( java.sql.Timestamp timestamp ) {
        this.timestamp = timestamp;
    }

    /**
     * @return the agentRegularisateur
     */
    public Agent getAgentRegularisateur() {
        return agentRegularisateur;
    }

    /**
     * @param agentRegularisateur
     *            the agentRegularisateur to set
     */
    public void setAgentRegularisateur( Agent agentRegularisateur ) {
        this.agentRegularisateur = agentRegularisateur;
    }

    /**
     * @return the motifRegularisation
     */
    public MotifRegularisation getMotifRegularisation() {
        return motifRegularisation;
    }

    /**
     * @param motifRegularisation
     *            the motifRegularisation to set
     */
    public void setMotifRegularisation( MotifRegularisation motifRegularisation ) {
        this.motifRegularisation = motifRegularisation;
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

    /**
     * @return the typeRegularisation
     */
    public TypeRegularisation getTypeRegularisation() {
        return typeRegularisation;
    }

    /**
     * @param typeRegularisation
     *            the typeRegularisation to set
     */
    public void setTypeRegularisation( TypeRegularisation typeRegularisation ) {
        this.typeRegularisation = typeRegularisation;
    }

    /**
     * @return the montantRegularisation
     */
    public float getMontantRegularisation() {
        return montantRegularisation;
    }

    /**
     * @param montantRegularisation
     *            the montantRegularisation to set
     */
    public void setMontantRegularisation( float montantRegularisation ) {
        this.montantRegularisation = montantRegularisation;
    }

}