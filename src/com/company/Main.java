package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    @Test
    public void generate_json_with_sign() {
        var mapper = new ObjectMapper();

        var product = new Product("Some test name", 65.23);

        try {
           var json = mapper.writerWithDefaultPrettyPrinter()
                   .writeValueAsString(product);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void read_double_value_with_dollar_sign_back_to_double() {
        var json = "{\n" +
                "  \"name\" : \"Some test name\",\n" +
                "  \"price\" : \"$65.23\"\n" +
                "}";

        var mapper = new ObjectMapper();

        try {
            var product = mapper.readValue(json, Product.class);
            System.out.println(product.getPrice());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
