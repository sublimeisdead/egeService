package ru.nahodka.bi.services.eventservice.util;


import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;

public class Util {

    public static Date toDate(XMLGregorianCalendar calendar) {
        if (calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }


}
