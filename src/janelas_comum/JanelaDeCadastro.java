package janelas_comum;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ouvintes_comum.OuvinteExternoSalvarCadastro;
import ouvintes_comum.OuvinteExternoVoltar;

public class JanelaDeCadastro extends Janela{
	private JTextField tfNome;
	private JTextField tfEmail;
	private JPasswordField tfSenha;
	
	public JanelaDeCadastro() {
		adicionarLabels();
		adicionarCampos();
		adicionarBotoes();

		setVisible(true);
	}
	
	private void adicionarLabels() {

		JLabel lbNome = new JLabel("Nome:");
		lbNome.setBounds(130, 100, 100, 40);
		lbNome.setForeground(Color.WHITE);
		lbNome.setFont(new Font("Arial", Font.BOLD,18));
		add(lbNome);

		JLabel lbEmail = new JLabel("E-mail:");
		lbEmail.setBounds(130, 150, 100, 40);
		lbEmail.setForeground(Color.WHITE);
		lbEmail.setFont(new Font("Arial", Font.BOLD,18));
		add(lbEmail);
		
		JLabel lbSenha = new JLabel("Senha:");
		lbSenha.setBounds(130, 200, 100, 40);
		lbSenha.setForeground(Color.WHITE);
		lbSenha.setFont(new Font("Arial", Font.BOLD,18));
		add(lbSenha);
		
	}
	private void adicionarCampos(){
		tfNome = new JTextField();
		tfNome.setBounds(200, 100, 150, 30);
		tfNome.setOpaque(true);
		tfNome.setBackground(Color.LIGHT_GRAY);
		tfNome.setForeground(Color.BLACK);
		tfNome.setFont(new Font("Arial", Font.BOLD,15));
		add(tfNome);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(200, 150, 150, 30);
		tfEmail.setOpaque(true);
		tfEmail.setBackground(Color.LIGHT_GRAY);
		tfEmail.setForeground(Color.BLACK);
		tfEmail.setFont(new Font("Arial", Font.BOLD,15));
		add(tfEmail);
		
		tfSenha = new JPasswordField();
		tfSenha.setBounds(200, 200, 150, 30);
		tfSenha.setOpaque(true);
		tfSenha.setBackground(Color.LIGHT_GRAY);
		tfSenha.setForeground(Color.BLACK);
		tfSenha.setFont(new Font("Arial", Font.BOLD,15));
		add(tfSenha);
		
	}
	private void adicionarBotoes(){
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBounds(260, 250, 120, 25);
		btCadastrar.setOpaque(true);
		btCadastrar.setForeground(Color.WHITE);
		btCadastrar.setBackground(Color.ORANGE);
		btCadastrar.setFont(new Font("Arial", Font.BOLD,18));
		OuvinteExternoSalvarCadastro ouvinteExternoSalvarCadastro = new OuvinteExternoSalvarCadastro(this);
		btCadastrar.addActionListener(ouvinteExternoSalvarCadastro);
		add(btCadastrar);
		
		JButton btVoltar = new JButton("Voltar");
		btVoltar.setBounds(100, 250, 120, 25);
		btVoltar.setOpaque(true);
		btVoltar.setForeground(Color.WHITE);
		btVoltar.setBackground(Color.ORANGE);
		btVoltar.setFont(new Font("Arial", Font.BOLD,18));
		OuvinteExternoVoltar ouvinteVoltar = new OuvinteExternoVoltar(this);
		btVoltar.addActionListener(ouvinteVoltar);
		add(btVoltar);
	}

	public JTextField getTfNome() {
		return tfNome;
	}

	public void setTfNome(JTextField tfNome) {
		this.tfNome = tfNome;
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

	public static void main(String[]args) {
		JanelaDeCadastro janelaDeCadastro = new JanelaDeCadastro();
		
	}

}
