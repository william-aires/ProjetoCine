package ouvintes_home_do_admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import janela_home_admin.JanelaControleDeSala;
import janela_home_admin.JanelaDetalharSalas;

public class OuvinteVoltarJanelaCadastroSala implements ActionListener {
	private JanelaDetalharSalas janela;
	
	public OuvinteVoltarJanelaCadastroSala(JanelaDetalharSalas janelaDetalharSalas) {
		// TODO Auto-generated constructor stub
		janela = janelaDetalharSalas;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new JanelaControleDeSala();
		janela.dispose();
	}
	

}
