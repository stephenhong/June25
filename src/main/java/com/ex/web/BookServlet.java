package com.ex.web;

import com.ex.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookServlet extends HttpServlet{
    /*Logging levels
        TRACE
        DEBUG
        INFO
        WARN
        ERROR
        FATAL
        ALL
     */
    static Logger logger = Logger.getLogger(BookServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // harcoding since before it was cool
        logger.info("Received request for book");
        Book b = new Book();
        b.setTitle("Web Programming for Dummies");
        b.setAuthor("August Duet");
        b.setPubYear("2020");

        logger.info(String.format("Sending response %s", b.getTitle()));

        String bJson = new ObjectMapper().writeValueAsString(b);
        resp.getWriter().write(bJson);
        resp.setStatus(200);
        resp.setHeader("Content-Type", "application/json");

        System.out.println("Response Sent");
        logger.trace("Response Sent");
        logger.info("Response Sent");
    }
}
