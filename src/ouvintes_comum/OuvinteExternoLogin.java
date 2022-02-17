package ouvintes_comum;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Sistema.CentralDeInformacoes;
import Sistema.Persistencia;
import janela_home_admin.JanelaHomeAdmin;
import janela_home_usuario.JanelaHomeCliente;
import janelas_comum.JanelaDeLogin;
import usuarios.Administrador;
import usuarios.Cliente;
import usuarios.Usuario;

public class OuvinteExternoLogin implements ActionListener{
	private JanelaDeLogin janela;
	
	public OuvinteExternoLogin(JanelaDeLogin janelaDeLogin) {
		// TODO Auto-generated constructor stub
		janela = janelaDeLogin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();

		String email = janela.getTfEmail().getText();
		String senha = new String(janela.getTfSenha().getPassword());
		
		try {
			Usuario u = central.recuperarUsuario(email,senha);
			
			if(u instanceof Administrador) {
				new JanelaHomeAdmin(u);
				janela.dispose();
				
			}else if(u instanceof Cliente) {
				new JanelaHomeCliente(u);
				janela.dispose();
				
			}
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(janela, erro.getMessage());
			if(erro.getMessage().contentEquals("Senha Incorreta")) {
				janela.getTfSenha().setText("");
			}
		}
		
	}

}
