package controller;

import service.inMemoryDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {

    inMemoryDao dao;
    public RegisterController() {
        this.dao = inMemoryDao.getInstance();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/RegisterUser.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        req.setAttribute("username",userName);
        if(dao.userExists(userName)){
            req.getRequestDispatcher("/WEB-INF/UserExists.jsp").forward(req,resp);
        }else{
            try {
                dao.addUser(userName,password);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }

            resp.sendRedirect("/");
        }
    }

}
