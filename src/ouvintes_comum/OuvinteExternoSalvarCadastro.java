package ouvintes_comum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Sistema.CentralDeInformacoes;
import Sistema.Persistencia;
import janelas_comum.JanelaDeCadastro;
import usuarios.Cliente;

public class OuvinteExternoSalvarCadastro implements ActionListener {
	private JanelaDeCadastro janela;

	public OuvinteExternoSalvarCadastro(JanelaDeCadastro janelaDeCadastro) {
		// TODO Auto-generated constructor stub
		janela = janelaDeCadastro;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		Cliente cliente = new Cliente();
		cliente.setNome(janela.getTfNome().getText());
		cliente.setEmail(janela.getTfEmail().getText());
		cliente.setSenha(janela.getTfSenha().getText());
		
		try {
			central.adicionarUsuario(cliente);
			JOptionPane.showMessageDialog(janela, "Usuario Cadastrado");
			janela.getTfNome().setText("");
			janela.getTfEmail().setText("");
			janela.getTfSenha().setText("");
			p.salvarCentral(central);
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(janela, erro.getMessage());
		}
		
	}

}
