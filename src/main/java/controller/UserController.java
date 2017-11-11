package controller;

import dao.Dao;
import dao.DaoImpl;
import model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ps1X on 27.06.2017.
 */
public class UserController extends HttpServlet {
    private static String list_users = "/listUsers.jsp";
    private static String update = "/user.jsp";

    private Dao dao;

    public UserController() {
        dao = new DaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String forward = "";
        if (action.equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            dao.deleteUser(id);
            forward = list_users;
            req.setAttribute("users", dao.getAllUsers());
        } else if (action.equals("edit")) {
            forward = update;
            int id = Integer.parseInt(req.getParameter("id"));
            User user = dao.getUserById(id);
            req.setAttribute("user", user);
        } else if (action.equals("listUsers")) {
            forward = list_users;
            req.setAttribute("users", dao.getAllUsers());
        } else {
            forward = update;
        }
        RequestDispatcher rd = req.getRequestDispatcher(forward);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setEmail(req.getParameter("email"));
        try {
            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(req.getParameter("dob"));
            user.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String id = req.getParameter("id");
        if (id == null || id.isEmpty()) {
            dao.addUser(user);
        } else {
            user.setId(Integer.parseInt(id));
            dao.updateUser(user);
        }
        RequestDispatcher rd = req.getRequestDispatcher(list_users);
        req.setAttribute("users", dao.getAllUsers());
        rd.forward(req, resp);
    }

}
