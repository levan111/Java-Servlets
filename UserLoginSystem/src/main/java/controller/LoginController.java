package controller;

import entity.user;
import service.inMemoryDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;

public class LoginController extends HttpServlet {
    private inMemoryDao dao;

    public LoginController() {
        this.dao = inMemoryDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/WEB-INF/Loginview.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        req.setAttribute("username",username);

        try {
            if(dao.Login(username,password)){
                req.getRequestDispatcher("/WEB-INF/Logined.jsp").forward(req,resp);
            }else{
                req.getRequestDispatcher("/WEB-INF/UserDoesntExists.jsp").forward(req,resp);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

}
