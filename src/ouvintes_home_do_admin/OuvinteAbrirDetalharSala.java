package ouvintes_home_do_admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import Sistema.CentralDeInformacoes;
import Sistema.Persistencia;
import Sistema.Sala;
import janela_home_admin.JanelaControleDeSala;
import janela_home_admin.JanelaDetalharSalas;

public class OuvinteAbrirDetalharSala implements ActionListener{
	private JanelaControleDeSala janela;

	public OuvinteAbrirDetalharSala(JanelaControleDeSala janelaCadastroDeSala) {
		// TODO Auto-generated constructor stub
		janela = janelaCadastroDeSala;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();	
		JTable tabela = janela.getTabela();
		int linhSelecionada = tabela.getSelectedRow();
		String sala = (String) tabela.getValueAt(linhSelecionada, 0);
		new JanelaDetalharSalas(sala);
		janela.dispose();
	}

}
