
package jdbc.teste;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

import negocio.GeradorPDF;
import models.Candidato;

public class TestePDF {

	public static void main(String[] args) throws DocumentException, IOException {
		Candidato c = new Candidato();
		 
		c.setNome("dudu");
		c.setEmail("odilonflj@mail.com");
		c.setSenha("concursos");
		c.setData_nasc("11/01/1998");
		c.setCpf("66666323");
		c.setEnd("Carnaubas");		
		c.setTelefone("4668643");
		c.setEscolaridade(3);
		c.setExp("tecnico das computarias");
		c.setArea_atuacao("info");
		c.setApendices("PCIConcursos");
		
		GeradorPDF pdf = new GeradorPDF();
		pdf.criarDocumento(c);

	}

}
