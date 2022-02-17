package ouvintes_home_do_admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import janela_home_admin.JanelaControleDeSessoes;
import janela_home_admin.JanelaHomeAdmin;

public class OuvinteAbrirJanelaControleDeSessoes implements ActionListener {
	private JanelaHomeAdmin janela;

	public OuvinteAbrirJanelaControleDeSessoes(JanelaHomeAdmin janelaHomeAdmin) {
		// TODO Auto-generated constructor stub
		janela = janelaHomeAdmin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new JanelaControleDeSessoes();
		janela.dispose();
	}

}
