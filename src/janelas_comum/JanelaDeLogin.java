package janelas_comum;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ouvintes_comum.OuvinteDoResetarSenha;
import ouvintes_comum.OuvinteExternoLogin;
import ouvintes_comum.OuvinteExternoNovo;

public class JanelaDeLogin extends Janela {
	private JTextField tfEmail;
	private JPasswordField tfSenha;
	
	public JanelaDeLogin() {
		adicionarLabels();
		adicionarCampoDeTexto();
		adicionarBotoes();
		setTitle("Login");
		setVisible(true);
		
	}
	private void adicionarLabels() {

		JLabel lbEmail = new JLabel("E-mail:");
		lbEmail.setBounds(130, 100, 70, 40);
		lbEmail.setForeground(Color.WHITE);
		lbEmail.setFont(new Font("Arial", Font.BOLD,18));
		add(lbEmail);

		JLabel lbSenha = new JLabel("Senha:");
		lbSenha.setBounds(130, 150, 100, 40);
		lbSenha.setForeground(Color.WHITE);
		lbSenha.setFont(new Font("Arial", Font.BOLD,18));
		add(lbSenha);
		
		JLabel lbLink = new JLabel("Resetar senha?");
		lbLink.setBounds(260, 250, 125, 40);
		lbLink.setForeground(Color.WHITE);
		lbLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lbLink.setFont(new Font("Arial", Font.BOLD,17));
		OuvinteDoResetarSenha ouvinteResetar = new OuvinteDoResetarSenha(this);
		lbLink.addMouseListener(ouvinteResetar);
		add(lbLink);
	}

	private void adicionarCampoDeTexto() {
		tfEmail = new JTextField();
		tfEmail.setBounds(200, 100, 150, 30);
		tfEmail.setOpaque(true);
		tfEmail.setBackground(Color.LIGHT_GRAY);
		tfEmail.setForeground(Color.BLACK);
		tfEmail.setFont(new Font("Arial", Font.BOLD,15));
		add(tfEmail);

		tfSenha = new JPasswordField();
		tfSenha.setBounds(200, 150, 150, 30);
		tfSenha.setOpaque(true);
		tfSenha.setBackground(Color.LIGHT_GRAY);
		tfSenha.setForeground(Color.BLACK);
		tfSenha.setFont(new Font("Arial", Font.BOLD,15));
		add(tfSenha);

	}

	private void adicionarBotoes() {
		JButton btEntrar = new JButton("Entrar");
		btEntrar.setBounds(260, 200, 90, 25);
		btEntrar.setOpaque(true);
		btEntrar.setForeground(Color.WHITE);
		btEntrar.setBackground(Color.ORANGE);
		btEntrar.setFont(new Font("Arial", Font.BOLD,18));
		btEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteExternoLogin ouvinteEntrar = new OuvinteExternoLogin(this);
		btEntrar.addActionListener(ouvinteEntrar);
		add(btEntrar);

		JButton btNovo = new JButton("Novo");
		btNovo.setBounds(130, 200, 90, 25);
		btNovo.setForeground(Color.WHITE);
		btNovo.setBackground(Color.ORANGE);
		btNovo.setFont(new Font("Arial", Font.BOLD,18));
		btNovo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteExternoNovo ouvinteNovo = new OuvinteExternoNovo(this);
		btNovo.addActionListener(ouvinteNovo);
		add(btNovo);
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public void setTfEmail(JTextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	public JPasswordField getTfSenha() {
		return tfSenha;
	}
	public void setTfSenha(JPasswordField tfSenha) {
		this.tfSenha = tfSenha;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JanelaDeLogin janelaDeLogin = new JanelaDeLogin();
	}

}
