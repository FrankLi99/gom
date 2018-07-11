package com.ghc.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCustomConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try{ return sdf.parse(s);}
        catch(ParseException pe){
            pe.printStackTrace();
        }
        return null;
    }
}
