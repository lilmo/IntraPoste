/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Morgane
 */
public class DateAndCalendar {

    public static Calendar dateToCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
    
    public static Date calendarToDate (Calendar cal)
    {
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DATE);
        @SuppressWarnings( "deprecation" )
        Date date = new Date(year - 1900, month - 1, day);
        
        return date;
    }
    
    public static String timestampToString (Timestamp date)
    {
        Date maDate = new Date(date.getTime());
        SimpleDateFormat formaterDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dateTemp = formaterDate.format(maDate);
        
        return dateTemp;
    }
    
    //fusionne une date (format Date) et une heure (format Date) dans un format Date
    public static Date fusionDateHeure (Date datePart, Date heurePart)
    {
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(datePart);

        Calendar calendarTime = Calendar.getInstance();
        calendarTime.setTime(heurePart);

        calendarDate.set(Calendar.HOUR_OF_DAY, calendarTime.get(Calendar.HOUR_OF_DAY));
        calendarDate.set(Calendar.MINUTE, calendarTime.get(Calendar.MINUTE));

        Date maDate = calendarDate.getTime();
        return maDate;

    }
    
    //converti une heure format string (hh:mm) en date dd/MM/yy hh:mm
    public static Date heureStringToDate (String heureString) throws ParseException
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
        Date heureDateChoisie = dateFormat.parse(heureString);
        return heureDateChoisie;
    }
    
    //converti une heure stockée format date en String hh:mm
    public static String dateHeureToString (Date dateHeure)
    {
        String heureString;
        Calendar cal = dateToCalendar(dateHeure);
        
        Integer heures = cal.get(Calendar.HOUR_OF_DAY);
        Integer minutes = cal.get(Calendar.MINUTE);
        if (heures < 10)
            heureString = "0" + heures + ":";
        else
            heureString = heures + ":";
        if (minutes < 10)
            heureString += "0";
        heureString += minutes;
        
        return heureString;
    }
}
