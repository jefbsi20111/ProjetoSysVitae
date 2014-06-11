package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.servlet.annotation.WebServlet;

import models.User;


@WebServlet(name="login-empresa", urlPatterns={"/templates/login-empresa"})

public class LoginEmpresa extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				
				String email = request.getParameter("email");
				String senha = request.getParameter("senha");
				int id = 1;
				// Verificar se o usuário tem permissao

				User user = new User(email, senha, id);
				
				HttpSession s = request.getSession();
				s.setAttribute("User", user);
				s.setMaxInactiveInterval(600);

//				Cookie c = new Cookie("user", user.getNome());
//				c.setMaxAge(3600*60);
//				response.addCookie(c);
				
//				response.sendRedirect("/candidato/index.jsp");
				
			}

}
