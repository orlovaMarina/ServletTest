package com.example;

import com.example.dao.UserDaoImpl;
import com.example.dto.UserDto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {

    private UserDaoImpl service = UserDaoImpl.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out=response.getWriter();

        String lastName=request.getParameter("lastName");
        String firstName=request.getParameter("firstName");

        UserDto user = new UserDto(firstName, lastName);
        service.save(user);

        out.print("<p>Record saved successfully!</p>");
        request.getRequestDispatcher("index.html").include(request, response);
        out.close();
    }

}