package ouvintes_comum;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Sistema.CentralDeInformacoes;
import Sistema.EnviarEmail;
import Sistema.Persistencia;
import janelas_comum.JanelaDeLogin;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Usuario;



public class OuvinteDoResetarSenha implements MouseListener {
	private JanelaDeLogin janela;
	public OuvinteDoResetarSenha(JanelaDeLogin janelaDeLogin) {
		// TODO Auto-generated constructor stub
		janela = janelaDeLogin;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		EnviarEmail enviar = new EnviarEmail();
		String email = janela.getTfEmail().getText();
		try {
			central.resetarSenha(email);
			enviar.enviarEmail(email);
			JOptionPane.showMessageDialog(janela, "Senha resetada");
			p.salvarCentral(central);
			new JanelaDeLogin();
			janela.dispose();
		}catch(Exception erro1) {
			JOptionPane.showMessageDialog(janela, erro1.getMessage());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
