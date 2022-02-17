package ouvintes_home_do_admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import janela_home_admin.JanelaCadastrarSessao;
import janela_home_admin.JanelaControleDeSessoes;

public class OuvinteAbrirJanelaCadastrarSessao implements ActionListener {
	private JanelaControleDeSessoes janela;
	public OuvinteAbrirJanelaCadastrarSessao(JanelaControleDeSessoes janelaControleDeSessoes) {
		janela = janelaControleDeSessoes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new JanelaCadastrarSessao();
		janela.dispose();
		
	}

}
