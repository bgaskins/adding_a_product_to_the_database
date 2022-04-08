package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Product;
import com.utility.HibernateUtility;


@WebServlet("/productView")
public class ViewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public ViewProductServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		SessionFactory sessionFactory = HibernateUtility.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		@SuppressWarnings("unchecked")
		List<Product> productList = session.createQuery(" from Product").list();
		
			out.print("<h2>All Products<h2>");
			out.print("<style> table, td, th {border:2px solid black; padding: 15px;}</style>");
			out.print("<table>");
			out.print("<tr>");
			out.print("<th> Product ID </th>");
			out.print("<th> Product Name </th>");
			out.print("<th> Product Price </th>");
			out.print("</tr>");
		
		for(Product product : productList) {
			
			out.print("<tr>");
			out.print("<td>" + product.getProdId() + "</td>");
			out.print("<td>" + product.getProdName() + "</td>");
			out.print("<td>" + product.getProdPrice() + "</td>");
			out.print("</tr>");
			
		}
			out.print("</table> </body> </html>");
			session.close();
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
			
	}

}
