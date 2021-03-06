package com.tengen;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.halt;

/**
 * Created by jonathan on 8/26/2016.
 */
public class HelloWorldSparkFreemarkerStyle {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");

        try {
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name", "FreeMaker!");

            helloTemplate.process(helloMap, writer);
            get("/", (req, res) -> writer);
        } catch (Exception e) {
            halt(500);
            e.printStackTrace();
        }
    }
}
