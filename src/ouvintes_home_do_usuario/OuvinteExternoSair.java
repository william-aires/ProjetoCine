package ouvintes_home_do_usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import janela_home_usuario.JanelaHomeCliente;
import janelas_comum.JanelaDeLogin;

public class OuvinteExternoSair implements ActionListener {
	private JanelaHomeCliente janela;

	public OuvinteExternoSair(JanelaHomeCliente janelaHomeCliente) {
		// TODO Auto-generated constructor stub
		janela = janelaHomeCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new JanelaDeLogin();
		janela.dispose();
		
	}

}
