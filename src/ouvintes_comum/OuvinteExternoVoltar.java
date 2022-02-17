package ouvintes_comum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import janelas_comum.JanelaDeCadastro;
import janelas_comum.JanelaDeLogin;

public class OuvinteExternoVoltar implements ActionListener {
	private JanelaDeCadastro janela;

	public OuvinteExternoVoltar(JanelaDeCadastro janelaDeCadastro) {
		// TODO Auto-generated constructor stub
		janela = janelaDeCadastro;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new JanelaDeLogin();
		janela.dispose();
		
	}

}
