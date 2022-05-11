package com.example.parkhaus_v2;

import org.json.*;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.*;
import javax.json.*;
import javax.json.stream.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "parkhausServlet", value = "/parkhaus-servlet")
public class ParkhausServlet extends HttpServlet {
    private int besetzt;
    private final int PARKPLAETZE = 500;

    public void init() {
        besetzt = 0;
    }

    Parkhaus parkhaus = new Parkhaus(PARKPLAETZE);


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        response.setIntHeader("refresh",5);
        response.setContentType("text/html");
        String requestString = request.getParameter("act");
        boolean stop = false;
        if (requestString != null) {
            switch(requestString) {
                case "enter":

                    for(int i=0;i<20;i++){
                        parkhaus.simulateOnce();
                        parkhaus.einfahren();
                        besetzt = parkhaus.getBesetzt();

                    }
                    break;
                case "leave":
                    stop = true;
                    break;
                case "chart":
                    JSONObject root = new JSONObject()
                            .add("data", Json.createArrayBuilder()
                                    .add(Json.createObjectBuilder()
                                            .add("x", Car.asNrArray( cars())
                                            .add("y", Car.asDurationArray(cars()))
                                            .add("type", "bar")
                                            .add"name", "Duration")
                                    )
                                    .add(Json.createObjectBuilder()
                                            .add("x", Car.asNrArray( cars())
                                            .add("y", Car.asDurationArray(cars()))
                                            .add("type", "bar")
                                            .add"name", "Duration")
                                    ).add(Json.createObjectBuilder()
                                            .add("x", Car.asNrArray( cars())
                                            .add("y", Car.asDurationArray(cars()))
                                            .add("type", "bar")
                                            .add"name", "Duration")
                                    )
                            ).build();
                    out.println( root.toString() );
                    break;

            }
        }

        out.println(
                "<html>" +
                        "   <body>" +
                        "       <form action=\"parkhaus-servlet\" method=\"GET\">" +
                        "           Autos im Parkhaus: " + besetzt + "/" + PARKPLAETZE + "<br>" +
                        "           <input type=\"submit\" name=\"act\" value=\"enter\">" +
                        "           <input type=\"submit\" name=\"act\" value=\"leave\">" +
                        "       </form>" +
                        "   </body>" +
                        "</html>"
        );

    }

    public void destroy() {
    }

    public int getBesetzt() {
        return this.besetzt;
    }
}