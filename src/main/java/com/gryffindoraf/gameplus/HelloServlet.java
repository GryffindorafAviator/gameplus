package com.gryffindoraf.gameplus;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import org.json.JSONObject;
import org.apache.commons.io.IOUtils;

@WebServlet(name = "helloServlet", value = "/game")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        JSONObject game = new JSONObject();
        game.put("name", "World of Warcraft");
        game.put("developer", "Blizzard Entertainment");
        game.put("release_time", "Feb 11, 2005");
        game.put("website", "https://www.worldofwarcraft.com");
        game.put("price", 49.99);

        response.getWriter().print(game);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
        String name = jsonRequest.getString("name");
        String developer = jsonRequest.getString("developer");
        String releaseTime = jsonRequest.getString("release_time");
        String website = jsonRequest.getString("website");
        float price = jsonRequest.getFloat("price");

        System.out.println("Name is: " + name);
        System.out.println("Developer is: " + developer);
        System.out.println("Release time is: " + releaseTime);
        System.out.println("Price is: " + price);

        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "OK");
        response.getWriter().print(jsonResponse);
    }

    public void destroy() {
    }
}