package com.tengen;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Spark;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonathan on 8/27/2016.
 */
public class SparkFormsHandling {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(SparkFormsHandling.class, "/");
        try {
            Map<String, Object> fruitsMap = new HashMap<String, Object>();
            fruitsMap.put("fruits", Arrays.asList("orange", "banana", "apple", "watermellow"));


            Template fruitPickerTemplate = configuration.getTemplate("fruitPicker.ftl");
            StringWriter writer = new StringWriter();
            fruitPickerTemplate.process(fruitsMap, writer);
            Spark.get("/", ((request, response) -> writer));
        } catch (Exception e) {
            Spark.halt(500);
            e.printStackTrace();
        }

        Spark.post("/favorite_fruit", ((request, response) -> {
            final String fruit = request.queryParams("fruit");
            if (fruit == null)
                return "Why?";
            else
                return "fruta favorita: "+fruit;
        }));
    }
}
