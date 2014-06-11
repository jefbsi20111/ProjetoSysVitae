package negocio;

import java.io.UnsupportedEncodingException;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import models.Candidato;

public class EnviarEmail {
	static MailJava mail= new MailJava();
	
	public void senderMail(Candidato c)
			throws UnsupportedEncodingException, MessagingException {
		Mensagens m= new Mensagens();
		
		mail.setSmtpHostMail("smtp.gmail.com");
        //servidor smtp do gmail
		mail.setSmtpPortMail("587");
        //porta do gmail
		mail.setSmtpAuth("true");
        mail.setSmtpStarttls("true");
        mail.setUserMail("bsipweb@gmail.com");
        //email que criei para a página
        mail.setFromNameMail(c.getNome());
        mail.setPassMail("professorodilon");
        //senha
        mail.setCharsetMail("ISO-8859-1");
        mail.setSubjectMail("Vaga de emprego");
        //assunto
        mail.setBodyMail(m.htmlMessage());
        //corpo da mensagem presente na classe Mensagens.java
        mail.setTypeTextMail(MailJava.TYPE_TEXT_HTML);
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.port", "587");
		props.setProperty("mail.mime.charset", "ISO-8859-1");

		// classe anonima que realiza a autenticação
		// do usuario no servidor de email.
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mail.getUserMail(),
						mail.getPassMail());
			}
		};

		// Cria a sessao passando as propriedades e a autenticação
		Session session = Session.getDefaultInstance(props, auth);
		// Gera um log no console referente ao processo de envio
		session.setDebug(true);

		// cria a mensagem setando o remetente e seus destinatários
		Message msg = new MimeMessage(session);
		// aqui seta o remetente
		msg.setFrom(new InternetAddress(mail.getUserMail(), mail
				.getFromNameMail()));
		
				// setamos o 1° destinatario
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
						c.getEmail(), c.getNome()));
				
			

		// Adiciona um Assunto a Mensagem
		msg.setSubject(mail.getSubjectMail());

		// Cria o objeto que recebe o texto do corpo do email
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent(mail.getBodyMail(), mail.getTypeTextMail());

		// Monta a mensagem SMTP inserindo o conteudo, texto e anexos
		Multipart mps = new MimeMultipart();

		// adiciona o corpo texto da mensagem
		mps.addBodyPart(textPart);

		// adiciona a mensagem o conteúdo texto e anexo
		msg.setContent(mps);

		// Envia a Mensagem
		Transport.send(msg);
		
	}
}
