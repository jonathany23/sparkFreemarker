package com.tengen;

import spark.Spark;

/**
 * Created by jonathan on 8/27/2016.
 */
public class SparckRoutes {
    public static void main(String[] args) {
        Spark.get("/", ((request, response) -> "Hello World"));

        Spark.get("/test", ((request, response) -> "Hello World Test"));

        Spark.get("/echo/:thing", ((request, response) -> request.params(":thing")));
    }
}
