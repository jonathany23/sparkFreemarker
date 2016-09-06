package com.tengen;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import static spark.Spark.*;

/**
 * Created by jonathan on 8/25/2016.
 */
public class HelloWorldSparkStyle {
    public static void main(String[] args) {
        get("/", (req, res) -> "Hello World from Spark:)!");
    }
}
