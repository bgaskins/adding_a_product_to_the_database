package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Product;
import com.utility.HibernateUtility;


@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AddProductServlet() {
		super();
	}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");

			PrintWriter out = response.getWriter();
		try {
			//Retrieve user input from index.jsp.
			int productId = Integer.parseInt(request.getParameter("prodId"));
			String productName = request.getParameter("prodName");
			String productPrice = request.getParameter("prodPrice");

			SessionFactory sessionFactory = HibernateUtility.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
	
				Product product = new Product();
				product.setProdId(productId);
				product.setProdName(productName);
				product.setProdPrice(Double.parseDouble(productPrice));
					
				session.save(product);
				tx.commit();
				out.print("<h3> Product added successfully.<h3>");
				session.close();
				
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
		
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
