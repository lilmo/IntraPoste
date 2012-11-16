package bdd;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import metier.ErreursCaisseRegularisation;

public class ErreurCaisseRegularisationDAO {

    public static void init() throws SQLException {

        // TODO init ErreurCaisse
        empty();
        ErreurCaisseDAO.updateStatus( ErreurCaisseDAO.selectAll().get( 0 ).getErreurCaisseId(), 1 );
        insert( new java.sql.Timestamp( Calendar.getInstance().getTime().getTime() ), "TOTO_C", MotifRegularisationDAO
                .selectAll().get( 0 ).getCodeMotifRegularisation(), 0, ErreurCaisseDAO.selectAll().get( 0 )
                .getErreurCaisseId(), 0.0f );
        insert( new java.sql.Timestamp( Calendar.getInstance().getTime().getTime() ), "TOTO_T", MotifRegularisationDAO
                .selectAll().get( 0 ).getCodeMotifRegularisation(), 0, ErreurCaisseDAO.selectAll().get( 0 )
                .getErreurCaisseId(), 0.0f );
        insert( new java.sql.Timestamp( Calendar.getInstance().getTime().getTime() ), "TOTO_C", MotifRegularisationDAO
                .selectAll().get( 0 ).getCodeMotifRegularisation(), 0, ErreurCaisseDAO.selectAll().get( 0 )
                .getErreurCaisseId(), 0.0f );
        insert( new java.sql.Timestamp( Calendar.getInstance().getTime().getTime() ), "TOTO_B", MotifRegularisationDAO
                .selectAll().get( 0 ).getCodeMotifRegularisation(), 0, ErreurCaisseDAO.selectAll().get( 0 )
                .getErreurCaisseId(), 0.0f );
        insert( new java.sql.Timestamp( Calendar.getInstance().getTime().getTime() ), "TOTO_P", MotifRegularisationDAO
                .selectAll().get( 0 ).getCodeMotifRegularisation(), 0, ErreurCaisseDAO.selectAll().get( 0 )
                .getErreurCaisseId(), 0.0f );
        insert( new java.sql.Timestamp( Calendar.getInstance().getTime().getTime() ), "TOTO_C", MotifRegularisationDAO
                .selectAll().get( 0 ).getCodeMotifRegularisation(), 0, ErreurCaisseDAO.selectAll().get( 0 )
                .getErreurCaisseId(), 0.0f );
        insert( new java.sql.Timestamp( Calendar.getInstance().getTime().getTime() ), "TOTO_B", MotifRegularisationDAO
                .selectAll().get( 0 ).getCodeMotifRegularisation(), 0, ErreurCaisseDAO.selectAll().get( 0 )
                .getErreurCaisseId(), 0.0f );

    }

    public static void insert( Timestamp timestamp,
            String codeAgentRegularisateur,
            int motifRegularisation,
            int codeTypeRegularisation,
            int erreurCaisseId, float montantRegularisation ) throws SQLException {

        Statement insert = null;
        try {
            insert = Connexion.getInstance().getConnection()
                    .createStatement();
            insert.executeQuery( "INSERT INTO ERREURS_CAISSES_REGUL VALUES (to_timestamp ('" + timestamp.toString()
                    + "', 'YYYY-MM-DD HH24:MI:SS.FF3'), '"
                    + codeAgentRegularisateur + "', " + motifRegularisation + ", " + erreurCaisseId +
                    ", " + codeTypeRegularisation + ", " + montantRegularisation + ")" );
        } catch ( SQLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if ( insert != null )
                insert.close();
        }
    }

    public static ArrayList<ErreursCaisseRegularisation> selectByErreurCaisse(
            int erreurCaisseId ) {
        // TODO Auto-generated method stub
        return null;
    }

    public static void empty() throws SQLException {
        Statement insert = null;
        try {
            insert = Connexion.getInstance().getConnection().createStatement();
            insert.executeQuery( "DELETE FROM ERREURS_CAISSES_REGUL" );

        } catch ( SQLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if ( insert != null )
                insert.close();
        }
    }

}
