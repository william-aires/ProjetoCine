package Sistema;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class EnviarEmail {
	
	public void enviarEmail(String email) {
		
		Properties props = new Properties();
		    /** Parâmetros de conexão com servidor Gmail */
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.socketFactory.port", "465");
		    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.port", "465");
		 
		    Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
		           protected PasswordAuthentication getPasswordAuthentication() 
		           {
		                 return new PasswordAuthentication("williamaires52@gmail.com","sxiv4kz0r19");
		           }
		      });
		 
		    /** Ativa Debug para sessão */
		    session.setDebug(true);
		 
		    try {
		 
		      Message message = new MimeMessage(session);
		      message.setFrom(new InternetAddress("williamAires")); 
		      //Remetente
		      
		    //Destinatário(s)
		      Address[] toUser = InternetAddress.parse(email);  
		      
		      message.setRecipients(Message.RecipientType.TO, toUser);
		      message.setSubject("Nova senha!!!");//Assunto
		      message.setText("Sua nova senha é 1234 ");
		      /**Método para enviar a mensagem criada*/
		      Transport.send(message);
		 
		     } catch (MessagingException e) {
		        throw new RuntimeException(e);
		    }
		
	}
	public void enviarEmailCancelandoSessao(String email) {
		
		Properties props = new Properties();
		    /** Parâmetros de conexão com servidor Gmail */
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.socketFactory.port", "465");
		    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.port", "465");
		 
		    Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
		           protected PasswordAuthentication getPasswordAuthentication() 
		           {
		                 return new PasswordAuthentication("williamaires52@gmail.com","sxiv4kz0r19");
		           }
		      });
		 
		    /** Ativa Debug para sessão */
		    session.setDebug(true);
		 
		    try {
		 
		      Message message = new MimeMessage(session);
		      message.setFrom(new InternetAddress("williamAires")); 
		      //Remetente
		      
		    //Destinatário(s)
		      Address[] toUser = InternetAddress.parse(email);  
		      
		      message.setRecipients(Message.RecipientType.TO, toUser);
		      message.setSubject("Sessão Cancelada!!!");//Assunto
		      message.setText("Sua sessão foi cancelada em um dia");
		      /**Método para enviar a mensagem criada*/
		      Transport.send(message);
		 
		     } catch (MessagingException e) {
		        throw new RuntimeException(e);
		    }
		
	}

}
