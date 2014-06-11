package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import models.Vaga;
import jdbc.ConnectionFactory;



public class VagaDAO{
	// a conexão com o banco de dados
	  private Connection connection;
	  
	  
	  public VagaDAO() throws ClassNotFoundException, Throwable {
		    this.connection = new ConnectionFactory().getConnection();
		  }
	  
	  /**
	   * Método responsável por adicionar uma empresa ao BD. 
	 * @throws Throwable 
	   * **/
	  public void adicionar(Vaga vaga) throws Throwable{
		  
		  String sql = "insert into Vaga" +
                  " (carga_horaria_vaga,remuneracao_vaga,requisitos_vaga,desc_vaga,Empresa_id_empresa,Empresa_email_empresa)" +
                  " values (?,?,?,?,?,?)";
		  try {
			  
			  PreparedStatement stmt = connection.prepareStatement(sql);
		
			  // seta os valores
		      //stmt.setInt(1, (Integer) null);
		      stmt.setInt(1,vaga.getCarga_horaria());
		      stmt.setFloat(2,vaga.getRemuneracao());
		      stmt.setString(3,vaga.getRequisitos());
		      stmt.setString(4,vaga.getDescricao());
		      stmt.setLong(5,vaga.getEmpresa_id_empresa());
		      stmt.setString(6,vaga.getEmpresa_email_empresa());
		      
		      // executa
		      stmt.execute();
		      stmt.close();
	
		  }catch(SQLException e) {
			  throw new RuntimeException(e);
			  //System.out.println(e);
		  } finally {
			  connection.close();
		  }
		  
	  }
	  
	  /**
	   * Método responsável por retornar uma lista de objetos Empresa;
	   * **/
	  public List<Vaga> listar() {
		     try {
		         List<Vaga> vagas = new ArrayList<Vaga>();
		         PreparedStatement stmt = this.connection.
		                 prepareStatement("select * from Vaga");
		         ResultSet rs = stmt.executeQuery();
		 
		         while (rs.next()) {
		             // criando o objeto Vaga
		        	 Vaga vaga = new Vaga();
		        	 vaga.setId(rs.getLong("id_vaga"));
		        	 vaga.setCarga_horaria(rs.getInt("carga_horaria_vaga"));
		        	 vaga.setRemuneracao(rs.getFloat("remuneracao_vaga"));
		        	 vaga.setRequisitos(rs.getString("requisitos_vaga"));
		        	 vaga.setDescricao(rs.getString("desc_vaga"));
		        	 vaga.setEmpresa_id_empresa(rs.getLong("Empresa_id_empresa"));
		        	 vaga.setEmpresa_email_empresa(rs.getString("Empresa_email_empresa"));
		        	 
		        	// adicionando o objeto à lista
		        	 vagas.add(vaga);
		         }
		         rs.close();
		         stmt.close();
		         return vagas;
		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }
		 }
	  
	  /**
	   * Método responsável por retornar uma lista de objetos Vaga;
	   * **/
	  
	  
	  /**
	   * Método para alterar um objeto no BD
	 * @throws ParseException 
	   * **/
	  public void alterar(Vaga vaga, String s) throws ParseException {
		  String sql = "update Vaga set id_vaga=?,carga_horaria_vaga=?,remuneracao_vaga=?,requisitos_vaga=?,desc_vaga=?,Empresa_id_empresa=?,Empresa_email_empresa=? where Empresa_email_empresa=?";
		  try {
		         PreparedStatement stmt = connection.prepareStatement(sql);
		         stmt.setLong(1,vaga.getId());
		         stmt.setInt(2,vaga.getCarga_horaria());
			     stmt.setFloat(3,vaga.getRemuneracao());
			     stmt.setString(4,vaga.getRequisitos());
			     stmt.setString(5,vaga.getDescricao());
			     stmt.setLong(6,vaga.getEmpresa_id_empresa());
			     stmt.setString(7,vaga.getEmpresa_email_empresa());
		         stmt.setString(8,s);
		         stmt.execute();
		         stmt.close();
		     } catch (SQLException e) {
		    	 throw new RuntimeException(e);
		     }
	  }
	  
	  
	  public void remover(String s,long l) {
		     try {
		         PreparedStatement stmt = connection.prepareStatement("delete from Vaga where Empresa_email_empresa=? AND id_vaga=?");
		         stmt.setString(1, s);
		         stmt.setLong(2, l);
		         stmt.execute();
		         stmt.close();
		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }
		 }
	  /**
	   * Método responsável por retornar uma lista de objetos Vagas;
	   * **/
	  public List<Vaga> filtro_vagas(String desc) {
		     try {
		         List<Vaga> vagas = new ArrayList<Vaga>();
		         PreparedStatement stmt = this.connection.prepareStatement("select * from Vaga where desc_vaga like ?");
		         stmt.setString(1, desc);
		         ResultSet rs = stmt.executeQuery();

		         while (rs.next()) {
		             // criando o objeto Vaga
		        	 Vaga vaga = new Vaga();
		        	 vaga.setId(rs.getLong("id_vaga"));
		        	 vaga.setCarga_horaria(rs.getInt("carga_horaria_vaga"));
		        	 vaga.setRemuneracao(rs.getFloat("remuneracao_vaga"));
		        	 vaga.setRequisitos(rs.getString("requisitos_vaga"));
		        	 vaga.setDescricao(rs.getString("desc_vaga"));
		        	 vaga.setEmpresa_id_empresa(rs.getLong("Empresa_id_empresa"));
		        	 vaga.setEmpresa_email_empresa(rs.getString("Empresa_email_empresa"));

		        	// adicionando o objeto à lista
		        	 vagas.add(vaga);
		         }
		         rs.close();
		         stmt.close();
		         return vagas;
		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }
		 }
	  /**
	   * Retorna uma vaga em especifico, pela sua id
	   * **/
	  public Vaga filtro_vagas_id(Long id) {
		     try {
		         PreparedStatement stmt = this.connection.prepareStatement("select * from Vaga where id_vaga=?");
		         stmt.setLong(1,id);
		         ResultSet rs = stmt.executeQuery();
		         Vaga vaga = new Vaga();
		         while (rs.next()) {		             		        	 
		        	 vaga.setId(rs.getLong("id_vaga"));
		        	 vaga.setCarga_horaria(rs.getInt("carga_horaria_vaga"));
		        	 vaga.setRemuneracao(rs.getFloat("remuneracao_vaga"));
		        	 vaga.setRequisitos(rs.getString("requisitos_vaga"));
		        	 vaga.setDescricao(rs.getString("desc_vaga"));
		        	 vaga.setEmpresa_id_empresa(rs.getLong("Empresa_id_empresa"));
		        	 vaga.setEmpresa_email_empresa(rs.getString("Empresa_email_empresa"));
		        }
		         rs.close();
		         stmt.close();
		         return vaga;
		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }
		 } 


	}
