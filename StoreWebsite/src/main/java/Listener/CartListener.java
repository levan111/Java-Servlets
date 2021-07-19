package Listener;

import Entity.Cart;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class CartListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event){
        event.getSession().setAttribute("mycart",new Cart());
    }

}
