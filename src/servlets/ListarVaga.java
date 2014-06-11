package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.catalina.connector.Request;





import models.Vaga;
import dao.VagaDAO;

/**
 * Servlet implementation class ListaContatosLogic
 */
@WebServlet("/ListarVaga")
public class ListarVaga extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarVaga() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			executa(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			executa(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, ClassNotFoundException {
        VagaDAO dao = new VagaDAO();   
        
        req.setAttribute("vagas", dao.listar());
        req.getRequestDispatcher("index.jsp").forward(req, res);
        //RequestDispatcher rd =req.getRequestDispatcher("index.jsp");
        //rd.forward(req, res);
    }

}
