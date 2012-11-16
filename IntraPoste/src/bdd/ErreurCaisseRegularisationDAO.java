package bdd;

import java.sql.ResultSet;
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

    public static ArrayList<ErreursCaisseRegularisation> selectAll() throws SQLException
    {
        Statement select = null;
        ArrayList<ErreursCaisseRegularisation> results = new ArrayList<ErreursCaisseRegularisation>();
        try {
            select = Connexion.getInstance().getConnection().createStatement();
            String query = "SELECT * FROM ERREURS_CAISSES_REGUL";

            ResultSet result = select.executeQuery( query );

            while ( result.next() ) {
                results.add( new ErreursCaisseRegularisation( result.getTimestamp( "DTIME_REGULARISATION"),
                        result.getString( "CODE_AGENT" ), result
                                .getInt( "CODE_MOTIF_REGULARISATION" ), result
                                .getInt( "ERREUR_CAISSE_ID" ), result
                                .getInt( "CODE_TYPE_REGULARISATION" ), result
                                .getFloat( "MONTANT_REGULARISATION" ) ) );
            }
        } catch ( SQLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if ( select != null )
                select.close();
        }
        return results;
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
                    + codeAgentRegularisateur.toUpperCase() + "', " + motifRegularisation + ", " + erreurCaisseId +
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
            int erreurCaisseId ) throws SQLException {
        Statement select = null;
        ArrayList<ErreursCaisseRegularisation> results = new ArrayList<ErreursCaisseRegularisation>();
        try {
            select = Connexion.getInstance().getConnection().createStatement();
            String query = "SELECT * FROM ERREURS_CAISSES_REGUL WHERE ERREUR_CAISSE_ID = " + erreurCaisseId;

            ResultSet result = select.executeQuery( query );

            while ( result.next() ) {
                results.add( new ErreursCaisseRegularisation( result.getTimestamp( "DTIME_REGULARISATION"),
                        result.getString( "CODE_AGENT" ), result
                                .getInt( "CODE_MOTIF_REGULARISATION" ), result
                                .getInt( "ERREUR_CAISSE_ID" ), result
                                .getInt( "CODE_TYPE_REGULARISATION" ), result
                                .getFloat( "MONTANT_REGULARISATION" ) ) );
            }
        } catch ( SQLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if ( select != null )
                select.close();
        }
        return results;
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
