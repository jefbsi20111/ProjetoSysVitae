package negocio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.io.IOException;

import com.itextpdf.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import models.Candidato;

@SuppressWarnings("unused")
public class GeradorPDF {
public void criarDocumento(Candidato c) throws DocumentException, IOException{

Document doc = null;
        FileOutputStream os = null;
        

    try {
    	LinkedList<String> escolaridade=new LinkedList<String>();
		escolaridade.add("Médio imcompleto");
		escolaridade.add("Médio completo");
		escolaridade.add("Superior imcompleto");
		escolaridade.add("Superior completo");
    	
        //cria o documento tamanho A4, margens de 2,54cm
        doc = new Document(PageSize.A4, 72, 72, 72, 72);

        //cria a stream de saída
        os = new FileOutputStream("pdfMaroto.pdf");

        //associa a stream de saída ao
        PdfWriter.getInstance(doc, os);

        //abre o documento
        doc.open();

        //adiciona o texto ao PDF
        Paragraph p = new Paragraph(c.getNome(),new Font(FontFamily.COURIER, 20, Font.BOLD));
        doc.add(p);
        p = new Paragraph(" ");
        doc.add(p);
        p = new Paragraph("Dados pessoais ",new Font(FontFamily.COURIER, 15, Font.BOLD));
        doc.add(p);
        p = new Paragraph("Email: "+c.getEmail());
        doc.add(p);
        p = new Paragraph("Endereço: "+c.getEnd());
        doc.add(p);
        p = new Paragraph("Telefone:"+c.getTelefone());
        doc.add(p);
        p = new Paragraph("CP: "+c.getCpf());
        doc.add(p);
        p = new Paragraph("Data de nascimento: "+c.getData_nasc());
        doc.add(p);
        p = new Paragraph(" ");
        doc.add(p);
        p = new Paragraph("Dados profissionais ",new Font(FontFamily.COURIER, 15, Font.BOLD));
        doc.add(p);
        p = new Paragraph("Escolaridade: Ensino "+escolaridade.get(c.getEscolaridade()).toString());
        doc.add(p);
        p = new Paragraph("Área de atuação: "+c.getArea_atuacao());
        doc.add(p);
        p = new Paragraph("Apêndices: "+c.getApendices());
        doc.add(p);
        p = new Paragraph("Experiências profissionais: "+c.getExp());
        doc.add(p);
        p = new Paragraph("Eu só fiz o algoritmo, essas piadas são de Jefferson",new Font(FontFamily.COURIER, 20, Font.BOLD));
        doc.add(p);
        } finally {
            if (doc != null) {
                //fechamento do documento
                doc.close();
            }
            if (os != null) {
               //fechamento da stream de saída
               os.close();
            }
        }
}
}