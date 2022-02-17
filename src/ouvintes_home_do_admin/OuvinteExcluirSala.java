package ouvintes_home_do_admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import Sistema.CentralDeInformacoes;
import Sistema.Persistencia;
import Sistema.Sala;
import Sistema.Sessao;
import janela_home_admin.JanelaControleDeSala;

public class OuvinteExcluirSala implements ActionListener{
	private JanelaControleDeSala janela;

	public OuvinteExcluirSala(JanelaControleDeSala janelaCadastroDeSala) {
		// TODO Auto-generated constructor stub
		janela = janelaCadastroDeSala;
	}

	public void actionPerformed(ActionEvent e) {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		
		JTable tabela = janela.getTabela();
		int linhaSelecionada = tabela.getSelectedRow();				
		Sala sala = central.recuperarArrayDeSalas().get(linhaSelecionada);
		if(sala.getSessoesAtivas() == 0) {
			sala.setDisponivel("Deletada");
			JOptionPane.showMessageDialog(janela, "Sala Deletada");
		}
		else {
			JOptionPane.showMessageDialog(janela, "Sessões ativas ainda");
		}
		p.salvarCentral(central);
		janela.dispose();
		new JanelaControleDeSala();
		
	}

}
