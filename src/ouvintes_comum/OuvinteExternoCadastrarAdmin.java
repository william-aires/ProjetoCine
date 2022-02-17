package ouvintes_comum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Sistema.CentralDeInformacoes;
import Sistema.Persistencia;
import janelas_comum.JanelaDeCadastroAdmin;
import janelas_comum.JanelaDeLogin;
import usuarios.Administrador;

public class OuvinteExternoCadastrarAdmin implements ActionListener {
	private JanelaDeCadastroAdmin janela;

	public OuvinteExternoCadastrarAdmin(JanelaDeCadastroAdmin janelaDeCadastroAdmin) {
		// TODO Auto-generated constructor stub
		janela = janelaDeCadastroAdmin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		Administrador admin = new Administrador();
		admin.setNome(janela.getTfNome().getText());
		admin.setEmail(janela.getTfEmail().getText());
		admin.setSenha(new String (janela.getTfSenha().getPassword()));
		
		try {
			central.adicionarAdmin(admin);
			JOptionPane.showMessageDialog(janela, "Administrador Cadastrado");
			new JanelaDeLogin();
			janela.dispose();
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(janela, erro.getMessage());
			if(erro.getMessage().equals("Administrador já Cadastrado")) {
				new JanelaDeLogin();
				janela.dispose();
			}
		}
		p.salvarCentral(central);
	}
}
