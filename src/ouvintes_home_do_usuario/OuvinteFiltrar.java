package ouvintes_home_do_usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Sistema.CentralDeInformacoes;
import Sistema.Persistencia;
import Sistema.Sala;
import Sistema.Sessao;
import janela_home_usuario.JanelaHomeCliente;

public class OuvinteFiltrar implements ActionListener{
	private JanelaHomeCliente janela;

	public OuvinteFiltrar(JanelaHomeCliente janelaHomeCliente) {
		// TODO Auto-generated constructor stub
		janela = janelaHomeCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		JTable tabela = janela.getTabela();
		DefaultTableModel modelo = janela.getModelo();
		
		String filtro = (String)janela.getJcFiltro().getSelectedItem();
		
		if(filtro.equals("Ativas")) {
			while (tabela.getModel().getRowCount() > 0) {  
				modelo.removeRow(0);
				tabela.repaint();
		       } 
			for(Sala sala: central.recuperarArrayDeSalas()) {
				for(Sessao sessao: sala.getSessoes()) {
					Object [] linha = new Object[7];
					if(sessao.getDisponivel().equals("Sim")) {
						linha[0] = sala.getNomeDaSala();
						linha[1] = sessao.getFilme();
						linha[2] = sessao.getHoraDeInicio();
						linha[3] = sessao.getDisponivel();
						linha[4] = sessao.getVagas();
						linha[5] = sala.getPrecoDoIngresso();
						linha[6] = sessao.getId();
						modelo.addRow(linha);
					}	
				}
			}
		}
		else if(filtro.equals("Todas")) {
			while (tabela.getModel().getRowCount() > 0) {  
				modelo.removeRow(0);
				tabela.repaint();
		       } 
			for(Sala sala: central.recuperarArrayDeSalas()) {
				for(Sessao sessao: sala.getSessoes()) {
					Object [] linha = new Object[7];
					linha[0] = sala.getNomeDaSala();
					linha[1] = sessao.getFilme();
					linha[2] = sessao.getHoraDeInicio();
					linha[3] = sessao.getDisponivel();
					linha[4] = sessao.getVagas();
					linha[5] = sala.getPrecoDoIngresso();
					linha[6] = sessao.getId();
					modelo.addRow(linha);			
				}
			}
		}
	}
}
