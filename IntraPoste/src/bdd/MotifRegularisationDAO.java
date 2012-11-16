package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metier.MotifRegularisation;

public class MotifRegularisationDAO {

    public static void init() throws SQLException {
        empty();
        insert( "REJET REGULARISE" );
        insert( "ERREUR RETROUVEE" );
        insert( "COMBLEE EN NUMERAIRE" );
        insert( "PRISE EN RECETTE" );
        insert( "REMBOURSEE A L UTILISATEUR" );
        insert( "ERREUR DE COMPTABILITE RETROUVEE" );
    }

    public static ArrayList<MotifRegularisation> selectAll()
            throws SQLException {
        ArrayList<MotifRegularisation> results = new ArrayList<>();
        Statement select = null;
        try {
            select = Connexion.getInstance().getConnection().createStatement();
            ResultSet result = select
                    .executeQuery( "SELECT CODE_MOTIF_REGULARISATION, DESCRIPTION_MOTIF_REGUL FROM MOTIF_REGULARISATION" );
            while ( result.next() )
                results.add( new MotifRegularisation( result
                        .getInt( "CODE_MOTIF_REGULARISATION" ), result
                        .getString( "DESCRIPTION_MOTIF_REGUL" ) ) );
        } catch ( SQLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if ( select != null )
                select.close();
        }
        return results;
    }

    public static MotifRegularisation selectByCode( int codeMotifRegularisation )
            throws SQLException {
        Statement select = null;
        try {
            select = Connexion.getInstance().getConnection().createStatement();
            ResultSet result = select
                    .executeQuery( "SELECT CODE_MOTIF_REGULARISATION, DESCRIPTION_MOTIF_REGUL FROM MOTIF_REGULARISATION WHERE CODE_MOTIF_REGULARISATION = "
                            + codeMotifRegularisation );
            if ( result.next() )
                return ( new MotifRegularisation(
                        result.getInt( "CODE_MOTIF_REGULARISATION" ),
                        result.getString( "DESCRIPTION_MOTIF_REGUL" ) ) );
        } catch ( SQLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if ( select != null )
                select.close();
        }
        return null;
    }

    public static MotifRegularisation selectByNom(
            String nomMotifRegularisation ) throws SQLException {
        Statement select = null;
        try {
            select = Connexion.getInstance().getConnection().createStatement();
            ResultSet result = select
                    .executeQuery( "SELECT CODE_MOTIF_REGULARISATION, DESCRIPTION_MOTIF_REGUL FROM MOTIF_REGULARISATION WHERE DESCRIPTION_MOTIF_REGUL LIKE '"
                            + nomMotifRegularisation.toUpperCase() + "'" );
            while ( result.next() )
                return new MotifRegularisation( result
                        .getInt( "CODE_MOTIF_REGULARISATION" ), result
                        .getString( "DESCRIPTION_MOTIF_REGUL" ) );
        } catch ( SQLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if ( select != null )
                select.close();
        }
        return null;
    }

    public static boolean insert( String nomMotifRegularisation )
            throws SQLException {
        Statement insert = null;
        try {
            if ( selectByNom( nomMotifRegularisation ) == null ) {
                insert = Connexion.getInstance().getConnection()
                        .createStatement();
                insert.executeQuery( "INSERT INTO MOTIF_REGULARISATION VALUES ('', '"
                        + nomMotifRegularisation.toUpperCase() + "')" );
                return true;
            }
        } catch ( SQLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if ( insert != null )
                insert.close();
        }
        return false;
    }

    public static boolean update( int codeMotifRegularisation,
            String nomMotifRegularisation ) throws SQLException {
        Statement insert = null;
        try {
            if ( selectByCode( codeMotifRegularisation ) != null ) {
                insert = Connexion.getInstance().getConnection()
                        .createStatement();
                insert.executeQuery( "UPDATE MOTIF_REGULARISATION SET DESCRIPTION_MOTIF_REGUL = '"
                        + nomMotifRegularisation.toUpperCase()
                        + "' WHERE CODE_MOTIF_REGULARISATION = "
                        + codeMotifRegularisation );
                return true;
            }
        } catch ( SQLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if ( insert != null )
                insert.close();
        }
        return false;
    }

    public static void empty() throws SQLException {
        Statement insert = null;
        try {
            insert = Connexion.getInstance().getConnection().createStatement();
            insert.executeQuery( "DELETE FROM MOTIF_REGULARISATION" );

        } catch ( SQLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if ( insert != null )
                insert.close();
        }
    }

}
