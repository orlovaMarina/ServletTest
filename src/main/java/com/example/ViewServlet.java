package com.example;

import com.example.dao.UserDaoImpl;
import com.example.dto.UserDto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

    private UserDaoImpl service = UserDaoImpl.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        out.println("<a href='index.html'>Add New User</a>");
        out.println("<h1>Users List</h1>");

        List<UserDto> users= service.getAll();

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Last Name</th><th>First Name</th></tr>");
        for(UserDto e:users){
            out.print("<tr><td>"+e.getLastName()+"</td><td>"+e.getFirstName()+"</td>"
//                    "<td><a href='EditServlet?id="+e.+"'>edit</a></td>" +
////                    "<td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>"
            );
        }
        out.print("</table>");

        out.close();
    }
}

