package ru.nahodka.bi.services.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Deprecated
public class DateAdapter extends XmlAdapter <String,Date> {

    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date unmarshal(String v) throws Exception {
        if(v.length() == 0) {
            return null;
        }
        return sdf.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        if(null == v) {
            return null;
        }
        return sdf.format(v);
    }
}
