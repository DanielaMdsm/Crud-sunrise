/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sunrise.crud.controller;

import com.sunrise.crud.UserDao.UserDAO;
import com.sunrise.crud.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author danie
 */
@WebServlet(name = "admin", urlPatterns = "/admin")
public class UserServlet extends HttpServlet {

    private UserDAO userDao;
    private final String URL_LIST = "WEB-INF/users/listUsers.jsp";
    private final String URL_UPDATE = "WEB-INF/users/updateUsers.jsp";

    @Override
    public void init() throws ServletException {
        userDao = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user;
        int id;
        String accion = req.getParameter("accion");
        accion = accion == null ? "" : accion;
        switch (accion) {
            case "editar":

                id = Integer.parseInt(req.getParameter("id"));
                user = userDao.getUser(id);
                req.getSession().setAttribute("usuario", user);
                req.getRequestDispatcher(URL_UPDATE).forward(req, resp);
                break;
            case "eliminar":

                id = Integer.parseInt(req.getParameter("id"));
                userDao.removeUser(id);
                resp.sendRedirect(req.getContextPath() + "/admin");

                break;

            default:
                req.setAttribute("listaUsuarios", userDao.getUsers());
                req.getRequestDispatcher(URL_LIST).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user;
        int id;
        String accion = req.getParameter("accion");
        accion = accion == null ? "" : accion;
        switch (accion) {
            case "insert":
                user = updateParam(req);
                userDao.addUser(user);
                resp.sendRedirect(req.getContextPath());
                break;
            case "update": 
                id= Integer.parseInt(req.getParameter("id"));
                user=updateParam(req);
                user.setId(id);
                userDao.updateUser(user);
                resp.sendRedirect(req.getContextPath() + "/admin");
                break;
                
        }
    }

    private User updateParam(HttpServletRequest req) {
        User user = new User();
        user.setName(req.getParameter("nombre"));
        user.setLastName(req.getParameter("apellido"));
        user.setEmail(req.getParameter("email"));
        user.setConsultation(req.getParameter("consulta"));

        return user;
    }

}
