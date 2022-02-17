package ouvintes_comum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Sistema.CentralDeInformacoes;
import janelas_comum.JanelaDeCadastro;
import janelas_comum.JanelaDeLogin;
import usuarios.Usuario;


public class OuvinteExternoNovo implements ActionListener {
	private JanelaDeLogin janela;

	public OuvinteExternoNovo(JanelaDeLogin janelaDeLogin) {
		janela = janelaDeLogin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new JanelaDeCadastro();
		janela.dispose();
	}

}
