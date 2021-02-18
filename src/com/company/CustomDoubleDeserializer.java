package com.company;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class CustomDoubleDeserializer extends StdDeserializer<Double> {

    public CustomDoubleDeserializer() {
        this(null);
    }

    protected CustomDoubleDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Double deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        var str = jsonParser.getText();
        return Double.parseDouble(str.substring(1));
    }
}
