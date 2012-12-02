package tools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import metier.Agent;
import bdd.AgentDAO;

public class Check {

    public static Boolean checkAgent( HttpServletRequest request )
    {
        HttpSession session = request.getSession();

        while ( session.getAttributeNames().hasMoreElements() )
            if ( session.getAttributeNames().nextElement().equals( "codeAgent" ) )
                if ( AgentDAO.selectByCode( (String) session.getAttribute( "codeAgent" ) ) != null )
                    return true;
        return false;
    }

    public static Boolean checkTypeAgent( String typeAgent, Agent agent )
    {
        if ( agent != null )
            switch ( typeAgent ) {
            case "guichet":
                if ( agent.getTypeAgent().getCodeTypeAgent() == 2 )
                    return true;

            case "comptable":
                if ( agent.getTypeAgent().getCodeTypeAgent() == 1 )
                    return true;

            case "superieur":
                if ( ( agent.getTypeAgent().getCodeTypeAgent() == 1 )
                        || ( agent.getTypeAgent().getCodeTypeAgent() == 0 ) )
                    return true;

            default:
                return false;
            }
        else
            return false;
    }
}
