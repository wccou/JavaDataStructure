package me.hitwcc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.batch.Main;

/**
 * Servlet implementation class HW
 */
@WebServlet("/HW")
public class HW extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HW() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		out.println("Helladadsadasdasaso!");
		out.println("111111111111!");
		out.println("assdsdsadadada654646!");
		out.println("fuck!");
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	public static void main(String[] args) {
		
	}

}