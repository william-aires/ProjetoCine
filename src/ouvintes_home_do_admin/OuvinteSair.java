package ouvintes_home_do_admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import janela_home_admin.JanelaHomeAdmin;
import janelas_comum.JanelaDeLogin;

public class OuvinteSair implements ActionListener {
	private JanelaHomeAdmin janela;
	
	public OuvinteSair(JanelaHomeAdmin janelaHomeAdmin) {
		// TODO Auto-generated constructor stub
		janela = janelaHomeAdmin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new JanelaDeLogin();
		janela.dispose();
		
	}

}
