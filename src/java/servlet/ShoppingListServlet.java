/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 816590
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = (String) request.getParameter("action");
        String user = (String) session.getAttribute("username");

        if (action == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

        } else if (action.equals("logout")) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        if (user == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = (String) request.getParameter("action");
        String user = request.getParameter("username");
        ArrayList<String> itemList = new ArrayList<>();

        switch (action) {
            case "register":
                session.setAttribute("username", user);
                break;
            case "add":
                String item = request.getParameter("addItem");
                itemList.add(item);
                session.setAttribute("itemList", itemList);
                break;
            case "delete":
                String deleteItem = request.getParameter("item");
                itemList.remove(deleteItem);
                session.setAttribute("itemList", itemList);
                break;
            default:
                break;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }
}
