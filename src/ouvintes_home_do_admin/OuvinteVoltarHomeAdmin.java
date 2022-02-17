package ouvintes_home_do_admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.NoConnectionPendingException;

import Sistema.CentralDeInformacoes;
import Sistema.Persistencia;
import janela_home_admin.JanelaCadastroDeFilmes;
import janela_home_admin.JanelaControleDeSala;
import janela_home_admin.JanelaControleDeSessoes;
import janela_home_admin.JanelaHomeAdmin;
import usuarios.Administrador;
import usuarios.Usuario;

public class OuvinteVoltarHomeAdmin implements ActionListener {
	private JanelaControleDeSala janela1;
	private JanelaCadastroDeFilmes janela2;
	private JanelaControleDeSessoes janela3;
	private Usuario u;

	public OuvinteVoltarHomeAdmin(JanelaControleDeSala janelaCadastroDeSala) {
		// TODO Auto-generated constructor stub
		janela1 = janelaCadastroDeSala;
	}

	public OuvinteVoltarHomeAdmin(JanelaCadastroDeFilmes janelaCadastroDeFilmes) {
		// TODO Auto-generated constructor stub
		janela2 = janelaCadastroDeFilmes;
	}

	public OuvinteVoltarHomeAdmin(JanelaControleDeSessoes janelaControleDeSessoes) {
		// TODO Auto-generated constructor stub
		janela3 = janelaControleDeSessoes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		for(Usuario u: central.getUsuarios()) {
			if(u instanceof Administrador) {
				new JanelaHomeAdmin(u);
			}
		}
			
		
		if(janela1 != null)
			janela1.dispose();
		else if(janela2 != null)
			janela2.dispose();
		else if(janela3 != null)
			janela3.dispose();
	}

}
