package servlets;

import java.io.IOException;
//import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;







import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;







import negocio.*;

/*import negocio.EnviarEmail;
import negocio.MailJava;
import negocio.Mensagens;*/
import dao.*;
import models.*;


@WebServlet(name="cadastrar-vaga", urlPatterns={"/templates/vagas/cadastrar-vaga"})


public class AddVagaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpServletRequest request = (HttpServletRequest) req;  	
		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("User");
		String email = user.getEmail();
		
		String cargaHoraria = req.getParameter("cargaHoraria");
		String remuneracao = req.getParameter("remuneraca");
		String requisitos = req.getParameter("requisitos");
		//String desc = req.getParameter("desc");
		int carga = Integer.parseInt(cargaHoraria);
		float remum = Float.parseFloat(remuneracao);
		
		Vaga vaga = new Vaga();
		vaga.setCarga_horaria(carga);
		vaga.setRemuneracao(remum);
		vaga.setRequisitos(requisitos);

		
		
		EmpresaDAO empresaDao;
		try {
			empresaDao = new EmpresaDAO();
			Empresa empresa = empresaDao.filtro_email(email);
			vaga.setEmpresa_email_empresa(empresa.getEmail());
			vaga.setEmpresa_id_empresa(empresa.getId());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
  

		

		//req.getRequestDispatcher("ListServlet").forward(req, resp);
		CandidatoDAO cdao;
		List<Candidato> candidatos = new ArrayList<Candidato>();
		try {
			cdao = new CandidatoDAO();
			
			candidatos = cdao.filtro_requisitos(requisitos);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		/**
		MailJava mj = new MailJava();
		Mensagens m= new Mensagens();
	    //configuracoes de envio
	    mj.setSmtpHostMail("smtp.gmail.com");
	    mj.setSmtpPortMail("587");
	    mj.setSmtpAuth("true");
	    mj.setSmtpStarttls("true");
	    mj.setUserMail("tiagomdantas2011@gmail.com");
	    mj.setFromNameMail("Tiago Dantas");
	    mj.setPassMail("2513422129631221");
	    mj.setCharsetMail("ISO-8859-1");
	    mj.setSubjectMail("JavaMail");
	    mj.setBodyMail(m.htmlMessage());
	    mj.setTypeTextMail(MailJava.TYPE_TEXT_HTML);
	    **/
	    
		EnviarEmail enviarEail = new EnviarEmail();
	    //sete quantos destinatarios desejar
	    for(Candidato candidato:candidatos){
	    	try {
				enviarEail.senderMail(candidato);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		    }
	 
	    //Map<String, String> map = new HashMap<String, String>();
	    //map.put(candidato.getEmail(),candidato.getNome());
	    //mj.setToMailsUsers(map);
	}

	}

