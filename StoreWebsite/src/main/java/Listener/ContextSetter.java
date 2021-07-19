package Listener;

import Repository.Database;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class ContextSetter implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent eve) {
        try {
            eve.getServletContext().setAttribute("database", new Database() {
            });
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
