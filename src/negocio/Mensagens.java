package negocio;

public class Mensagens {
	public String textMessage() {
        return  "Leia o novo tutorial JavaMail do Programando com Java.n" +
                "Saiba como enviar emails com anexo, em formato texto e html.n" +
                "Envie seu email para mais de um destinatario.";
    }
 
    public String htmlMessage() {
        return
        "<html>"
        + "<head>"
        + "<title>Surgimento de vaga</title>"
        + "</head>"
        + "<body>"
        + "<h1>Gostaríamos de informar que surgiu uma vaga para o para o cargo que você deseja!</h1>"
        + "</body>"
        + "</html>";
    }
}

