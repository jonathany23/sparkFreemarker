package com.tengen;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by jonathan on 8/26/2016.
 */
public class HelloWorldFreemarkerStyle {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");

        try {
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name", "FreeMaker");
            helloMap.put("Apellido", "Ferreira");

            helloTemplate.process(helloMap, writer);
            System.out.println(writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
