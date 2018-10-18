package ru.nahodka.bi.services.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.postgresql.util.PGobject;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.sql.SQLException;

@Deprecated
@Converter
public class StringToJSONConverter implements AttributeConverter<String, PGobject> {

    @Override
    public PGobject convertToDatabaseColumn(String string) {
        try {
            PGobject po = new PGobject();
            // here we tell Postgres to use JSON as type to treat our json
            po.setType("json");
            // this is Jackson already added as dependency to project, it could be any JSON marshaller
            po.setValue((new ObjectMapper()).writeValueAsString(string));
            return po;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String convertToEntityAttribute(PGobject po) {
        try {
            return (new ObjectMapper()).readValue(po.getValue(),String.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
