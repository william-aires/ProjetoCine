package ouvintes_home_do_admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import janela_home_admin.JanelaCadastroDeFilmes;
import janela_home_admin.JanelaHomeAdmin;

public class OuvinteAbrirJanelaCadastrarFilme implements ActionListener {
	private JanelaHomeAdmin janela;
	
	public OuvinteAbrirJanelaCadastrarFilme(JanelaHomeAdmin janelaHomeAdmin) {
		// TODO Auto-generated constructor stub
		janela = janelaHomeAdmin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new JanelaCadastroDeFilmes();
		janela.dispose();
	}

}
