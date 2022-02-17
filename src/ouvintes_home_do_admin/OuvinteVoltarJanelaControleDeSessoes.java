package ouvintes_home_do_admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import janela_home_admin.JanelaCadastrarSessao;
import janela_home_admin.JanelaControleDeSessoes;

public class OuvinteVoltarJanelaControleDeSessoes implements ActionListener {
	private JanelaCadastrarSessao janela;

	public OuvinteVoltarJanelaControleDeSessoes(JanelaCadastrarSessao janelaCadastrarSessao) {
		// TODO Auto-generated constructor stub
		janela = janelaCadastrarSessao;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new JanelaControleDeSessoes();
		janela.dispose();
	}

}
