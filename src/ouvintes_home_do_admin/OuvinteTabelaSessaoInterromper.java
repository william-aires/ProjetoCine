package ouvintes_home_do_admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import Sistema.CentralDeInformacoes;
import Sistema.Persistencia;
import Sistema.Sala;
import Sistema.Sessao;
import janela_home_admin.JanelaControleDeSessoes;

public class OuvinteTabelaSessaoInterromper implements ActionListener {
	private JanelaControleDeSessoes janela;

	public OuvinteTabelaSessaoInterromper(JanelaControleDeSessoes janelaControleDeSessoes) {
		// TODO Auto-generated constructor stub
		janela = janelaControleDeSessoes;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		
		JTable tabela = janela.getTabela();
		int linhaSelecionada =  (int) tabela.getSelectedRow();
		
		String nomeDaSala = (String) tabela.getValueAt(linhaSelecionada, 0);
		long idSessao = (long) tabela.getValueAt(linhaSelecionada, 6);
		
		for(Sala sala: central.recuperarArrayDeSalas()){
			if(sala.getNomeDaSala().equals(nomeDaSala))
				for(Sessao sessao: sala.getSessoes()){
					if(sessao.getId() == idSessao){
						sessao.setDisponivel("Interrompida");
						p.salvarCentral(central);
						janela.dispose();
						new JanelaControleDeSessoes();
						return;
					}
					
				}		
		}
				
		
		
	}

}
