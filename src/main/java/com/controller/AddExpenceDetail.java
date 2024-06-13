package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.ExpenceDao;
import com.Dao.UserDao;
import com.Dto.Expences;
import com.Dto.User;

@WebServlet("/expence")
public class AddExpenceDetail extends HttpServlet {

    private UserDao udo = new UserDao();
    private ExpenceDao ed = new ExpenceDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String date = req.getParameter("date");
        String expence = req.getParameter("expenseName");
        double price = Double.parseDouble(req.getParameter("price"));

        HttpSession session = req.getSession();
        User user1 = (User) session.getAttribute("user");

        Expences ep = new Expences();
        ep.setDate(date);
        ep.setExpence(expence);
        ep.setPrice(price);
        ep.setUser(user1);
        ed.saveExpence(ep);

        // Update user's money after the expense
        double updatePrice = user1.getMoney() - price;
        user1.setMoney(updatePrice);
        udo.saveUser(user1);

        // Retrieve updated list of expenses for the user

        resp.sendRedirect("home.jsp");
    }
}
