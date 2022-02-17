package janelas_comum;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Sistema.CentralDeInformacoes;
import Sistema.Persistencia;
import ouvintes_comum.OuvinteExternoCadastrarAdmin;
import usuarios.Administrador;
import usuarios.Usuario;

public class JanelaDeCadastroAdmin extends Janela {
	private JTextField tfNome;
	private JTextField tfEmail;
	private JPasswordField tfSenha;
	
	public JanelaDeCadastroAdmin() {
		adicionarLabels();
		adicionarCampos();
		adicionarBotoes();
		setTitle("Cadastrar Administrador");

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
		btCadastrar.setBounds(210, 250, 140, 25);
		btCadastrar.setOpaque(true);
		btCadastrar.setForeground(Color.WHITE);
		btCadastrar.setBackground(Color.ORANGE);
		btCadastrar.setFont(new Font("Arial", Font.BOLD,18));
		btCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteExternoCadastrarAdmin ouvinteCadastrarAdmin = new OuvinteExternoCadastrarAdmin(this);
		btCadastrar.addActionListener(ouvinteCadastrarAdmin);
		add(btCadastrar);
		
		
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		JanelaDeCadastroAdmin janela =  new JanelaDeCadastroAdmin();
		for(Usuario u: central.getUsuarios()){
			if(u instanceof Administrador){
				new JanelaDeLogin();
				janela.dispose();
			}
		}
		
	}

}
