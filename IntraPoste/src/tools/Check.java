package tools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import metier.Agent;
import metier.AgentComptable;
import metier.AgentGuichet;
import metier.AgentSuperieur;

public class Check {

    public static Agent checkAgent( HttpServletRequest request, String typeAgent )
    {
        HttpSession session = request.getSession();
        /* Récupération de l'objet depuis la session */

        AgentComptable agentComptable = null;
        AgentGuichet agentGuichet = null;
        AgentSuperieur agentSuperieur = null;

        switch ( typeAgent ) {
        case "guichet":
            try {
                agentGuichet = (AgentGuichet) session.getAttribute( "agent" );
            } catch ( ClassCastException e )
            {
                e.printStackTrace();
            }
            return agentGuichet;

        case "comptable":
            try {
                agentComptable = (AgentComptable) session.getAttribute( "agent" );
            } catch ( ClassCastException e )
            {
                e.printStackTrace();
            }
            return agentComptable;

        case "superieur":
            try {
                agentSuperieur = (AgentSuperieur) session.getAttribute( "agent" );
            } catch ( ClassCastException e )
            {
                e.printStackTrace();
            }

            try {
                agentComptable = (AgentComptable) agentSuperieur;
            } catch ( ClassCastException e1 )
            {
                return agentSuperieur;
            }
            return agentComptable;

        default:
            return null;
        }
    }
}
