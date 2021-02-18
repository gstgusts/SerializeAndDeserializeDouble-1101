package com.company;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CustomDoubleSerializer extends StdSerializer<Double> {

    public CustomDoubleSerializer() {
        this(null);
    }

    protected CustomDoubleSerializer(Class<Double> t) {
        super(t);
    }

    @Override
    public void serialize(Double v, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString("$" + v.toString());
    }
}
