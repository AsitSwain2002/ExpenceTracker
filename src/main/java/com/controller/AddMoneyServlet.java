package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.Dto.User;

@WebServlet("/addMoney")
public class AddMoneyServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		double money = Double.parseDouble(req.getParameter("moneyInput"));
		UserDao udo = new UserDao();
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		user.setMoney(user.getMoney()+money);
		udo.saveUser(user);
		session.setAttribute("user", user);
		resp.sendRedirect("home.jsp");
		
	}
	
}
