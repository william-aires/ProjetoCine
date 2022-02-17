package ouvintes_home_do_admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Sistema.Persistencia;
import janela_home_admin.JanelaControleDeSala;
import janela_home_admin.JanelaHomeAdmin;

public class OuvinteAbrirJanelaCadastroSala implements ActionListener {
	private JanelaHomeAdmin janela;

	public OuvinteAbrirJanelaCadastroSala(JanelaHomeAdmin janelaHomeAdmin) {
		// TODO Auto-generated constructor stub
		janela = janelaHomeAdmin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		new JanelaControleDeSala();
		janela.dispose();
		
	}

}
