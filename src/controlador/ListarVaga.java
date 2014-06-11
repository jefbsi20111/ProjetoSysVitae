

package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.mysql.jdbc.PreparedStatement;

import dao.VagaDAO;
import models.Vaga;

//@WebServlet(name="listar-vagas-index", urlPatterns={"/templates/index.jsp"})

public class ListarVaga {
	List<Vaga> vagas = new ArrayList<Vaga>();
	Connection connection;
	
	public ListarVaga(){
		
		//this.setLista();
	}
	
	public void setLista(){
				this.vagas = getLista();
	}
	
	public List<Vaga> getLista(){
		List<Vaga> vagas2 = new ArrayList<Vaga>();
try {
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/ProjetoSysVitae","root","");

				         PreparedStatement stmt = (PreparedStatement) connection.
				                 prepareStatement("select * from Vaga");
				         ResultSet rs = stmt.executeQuery();
				 
				         while (rs.next()) {
				             // criando o objeto Vaga
				        	 Vaga vaga = new Vaga();
				        	 vaga.setId(rs.getLong("id_vaga"));
				        	 vaga.setCarga_horaria(rs.getInt("carga_horaria"));
				        	 vaga.setRemuneracao(rs.getFloat("remuneracao"));
				        	 vaga.setRequisitos(rs.getString("requisitos"));
				        	 vaga.setDescricao(rs.getString("desc"));
				        	 vaga.setEmpresa_id_empresa(rs.getLong("Empresa_id_empresa"));
				        	 vaga.setEmpresa_email_empresa(rs.getString("Empresa_email_empresa"));
				        	 
				        	// adicionando o objeto à lista
				        	 vagas2.add(vaga);
				         }
				         rs.close();
				         stmt.close();
				     } catch (SQLException e) {
				         throw new RuntimeException(e);
				     }
		return vagas2;
	}
	
	public int isNull(){
		if(this.vagas == null){
			return 0; 
		}else{
			return 1;
		}
	}

	// Todo código aqui
	public List<Vaga> listar() throws Throwable{
		VagaDAO dao;
		dao = new VagaDAO();
		this.vagas = dao.listar();
		return vagas;
	}
}
