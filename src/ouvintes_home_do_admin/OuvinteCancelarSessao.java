package ouvintes_home_do_admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import Sistema.CentralDeInformacoes;
import Sistema.EnviarEmail;
import Sistema.Persistencia;
import Sistema.Sala;
import Sistema.Sessao;
import janela_home_admin.JanelaControleDeSessoes;

public class OuvinteCancelarSessao implements ActionListener {
	private JanelaControleDeSessoes janela;
	public OuvinteCancelarSessao(JanelaControleDeSessoes janelaControleDeSessoes) {
		// TODO Auto-generated constructor stub
		janela = janelaControleDeSessoes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JTable tabela = janela.getTabela();
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		int linhaSelecionada = tabela.getSelectedRow();
		String nomeDaSala = (String) tabela.getValueAt(linhaSelecionada, 0);
		long idDaSessao = (long) tabela.getValueAt(linhaSelecionada, 6);
		
		for(Sala s: central.recuperarArrayDeSalas()) {
			if(s.getNomeDaSala().equals(nomeDaSala)) {
				for(Sessao sessao: s.getSessoes()) {
					if(sessao.getId() == idDaSessao) {
						sessao.setDisponivel("Cancelada");
						p.salvarCentral(central);
					}
				}
			}
		}
		for(Sala s: central.recuperarArrayDeSalas()) {
			if(s.getNomeDaSala().equals(nomeDaSala)) {
				for(Sessao sessao: s.getSessoes()) {
					if(sessao.getId() == idDaSessao) {
						if(sessao.getDisponivel().equals("Cancelada")) {
							EnviarEmail enviar = new EnviarEmail();
							for(String email: sessao.getEmails()) {
								enviar.enviarEmailCancelandoSessao(email);
							}
						}
					}
				}
			}
		}
		JOptionPane.showMessageDialog(janela, "Emails enviados para os compradores");
		new JanelaControleDeSessoes();
		janela.dispose();
		
	}


}
