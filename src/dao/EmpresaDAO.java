package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import models.Empresa;


public class EmpresaDAO{
	// a conexão com o banco de dados
	  private Connection connection;
	  
	  public EmpresaDAO() throws ClassNotFoundException {
		    this.connection = new ConnectionFactory().getConnection();
		  }
	  
	  /**
	   * Método responsável por adicionar uma empresa ao BD. 
	 * @throws Throwable 
	   * **/
	  public void adicionar(Empresa empresa) throws Throwable{
		  
		  String sql = "insert into Empresa" +
                  " (nome_empresa,email_empresa,senha_empresa,cnpj_empresa,telefone_empresa,end_empresa)" +
                  " values (?,?,?,?,?,?)";
		  try {
			  
			  PreparedStatement stmt = connection.prepareStatement(sql);
		
			  // seta os valores
		      //stmt.setInt(1, (Integer) null);
		      stmt.setString(1,empresa.getNome());
		      stmt.setString(2,empresa.getEmail());
		      stmt.setString(3,empresa.getSenha());
		      stmt.setString(4,empresa.getCnpj());
		      stmt.setString(5,empresa.getEnd());
		      stmt.setString(6,empresa.getTelefone());
		
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
	  public List<Empresa> listar() {
		     try {
		         List<Empresa> empresas = new ArrayList<Empresa>();
		         PreparedStatement stmt = this.connection.
		                 prepareStatement("select * from Empresa");
		         ResultSet rs = stmt.executeQuery();
		 
		         while (rs.next()) {
		             // criando o objeto Empresa
		        	 Empresa empresa = new Empresa();
		        	 empresa.setId(rs.getLong("id_empresa"));
		        	 empresa.setNome(rs.getString("nome_empresa"));
		        	 empresa.setEmail(rs.getString("email_empresa"));
		        	 empresa.setSenha(rs.getString("senha_empresa"));
		        	 empresa.setCnpj(rs.getString("cnpj_empresa"));
		        	 empresa.setEnd(rs.getString("end_empresa"));
		        	 empresa.setTelefone(rs.getString("telefone_empresa"));
		 
		        	// adicionando o objeto à lista
		        	 empresas.add(empresa);
		         }
		         rs.close();
		         stmt.close();
		         return empresas;
		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }
		 }
	  
	  /**
	   * Método responsável por retornar uma lista de objetos Empresa;
	   * **/
	  
	  
	  /**
	   * Método para alterar um objeto no BD
	   * **/
	  public void alterar(Empresa empresa, String s) {
		  //Não funciona
		  String sql = "update Empresa set nome_empresa=?, email_empresa=?, senha_empresa=?, cnpj_empresa=?, end_empresa=?,telefone_empresa=? where nome_empresa=?";
		  try {
		         PreparedStatement stmt = connection.prepareStatement(sql);
		         stmt.setString(1,empresa.getNome());
			     stmt.setString(2,empresa.getEmail());
			     stmt.setString(3,empresa.getSenha());
			     stmt.setString(4,empresa.getCnpj());
			     stmt.setString(5,empresa.getEnd());
			     stmt.setString(6,empresa.getTelefone());
			     stmt.setString(7,s);
		         
		         stmt.execute();
		         stmt.close();
		     } catch (SQLException e) {
		    	 throw new RuntimeException(e);
		     }
	  }
	  
	  
	  public void remover(String s) {
		     try {
		         PreparedStatement stmt = connection.prepareStatement("delete" +
		                 " from Empresa where nome_empresa=?");
		         stmt.setString(1, s);
		         stmt.execute();
		         stmt.close();
		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }
		 }
	  
	  /**
	   * --------------------------------------------------------
	   * -----------PESQUISAS POR FILTROS------------------------
	   * --------------------------------------------------------
	   * **/
	  /**
	   * Pesquisa por nome de empresa
	   * **/
	  public List<Empresa> filtro_nome(String nome) {
		     try {
		         List<Empresa> empresas = new ArrayList<Empresa>();
		         PreparedStatement stmt = this.connection.prepareStatement("select * from Empresa where nome_empresa like ?");
		         stmt.setString(1, nome);
		         ResultSet rs = stmt.executeQuery();

		         while (rs.next()) {
		             // criando o objeto Empresa
		        	 Empresa empresa = new Empresa();
		        	 empresa.setId(rs.getLong("id_empresa"));
		        	 empresa.setNome(rs.getString("nome_empresa"));
		        	 empresa.setEmail(rs.getString("email_empresa"));
		        	 empresa.setSenha(rs.getString("senha_empresa"));
		        	 empresa.setCnpj(rs.getString("cnpj_empresa"));
		        	 empresa.setEnd(rs.getString("end_empresa"));
		        	 empresa.setTelefone(rs.getString("telefone_empresa"));

		        	// adicionando o objeto à lista
		        	 empresas.add(empresa);
		         }
		         rs.close();
		         stmt.close();
		         return empresas;
		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }
		 }
	  /**
	   * Pesquisa por email de empresa
	   * **/
	  public Empresa filtro_email(String email) {
		     try {
		         PreparedStatement stmt = this.connection.prepareStatement("select * from Empresa where email_empresa=?");
		         stmt.setString(1, email);
		         ResultSet rs = stmt.executeQuery();
		         Empresa empresa = new Empresa();
		         while (rs.next()) {
		             // criando o objeto Empresa

		        	 empresa.setId(rs.getLong("id_empresa"));
		        	 empresa.setNome(rs.getString("nome_empresa"));
		        	 empresa.setEmail(rs.getString("email_empresa"));
		        	 empresa.setSenha(rs.getString("senha_empresa"));
		        	 empresa.setCnpj(rs.getString("cnpj_empresa"));
		        	 empresa.setEnd(rs.getString("end_empresa"));
		        	 empresa.setTelefone(rs.getString("telefone_empresa"));

		         }
		         rs.close();
		         stmt.close();
		         return empresa;
		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }
		 }
	  /**
	   * Pesquisa por email de cnpj
	   * **/
	  public Empresa filtro_cnpj(String cnpj) {
		     try {
		         PreparedStatement stmt = this.connection.prepareStatement("select * from Empresa where cnpj_empresa=?");
		         stmt.setString(1, cnpj);
		         ResultSet rs = stmt.executeQuery();
		         Empresa empresa = new Empresa();
		         while (rs.next()) {
		             // criando o objeto Empresa

		        	 empresa.setId(rs.getLong("id_empresa"));
		        	 empresa.setNome(rs.getString("nome_empresa"));
		        	 empresa.setEmail(rs.getString("email_empresa"));
		        	 empresa.setSenha(rs.getString("senha_empresa"));
		        	 empresa.setCnpj(rs.getString("cnpj_empresa"));
		        	 empresa.setEnd(rs.getString("end_empresa"));
		        	 empresa.setTelefone(rs.getString("telefone_empresa"));

		         }
		         rs.close();
		         stmt.close();
		         return empresa;
		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }
		 }


	}
