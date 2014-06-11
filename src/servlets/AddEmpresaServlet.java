package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.EmpresaDAO;
import models.Empresa;

@WebServlet(name="cadastrar-empresa", urlPatterns={"/templates/empresa/cadastrar-empresa"})

public class AddEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String nomeFantasia = req.getParameter("nome");
		String cnpj = req.getParameter("cnpj");
		
		String email = req.getParameter("email");
		String end = req.getParameter("end");
		String senha = req.getParameter("senha");
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeFantasia);
		empresa.setEmail(email);
		empresa.setSenha(senha);
		empresa.setCnpj(cnpj);
		
		empresa.setEnd(end);

		//EmpresaDAO empresa_DAO = new EmpresaDAO();
		try {
			EmpresaDAO empresa_DAO = new EmpresaDAO();
			empresa_DAO.adicionar(empresa);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//req.getRequestDispatcher("ListServlet").forward(req, resp);

	}
}
