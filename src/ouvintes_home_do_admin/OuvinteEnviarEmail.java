package ouvintes_home_do_admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import Sistema.CentralDeInformacoes;
import Sistema.EnviarEmail;
import Sistema.Persistencia;
import Sistema.Sala;
import Sistema.Sessao;
import janela_home_admin.JanelaControleDeSessoes;

public class OuvinteEnviarEmail implements ActionListener {
	private JanelaControleDeSessoes janela;

	public OuvinteEnviarEmail(JanelaControleDeSessoes janelaControleDeSessoes) {
		// TODO Auto-generated constructor stub
		janela = janelaControleDeSessoes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		EnviarEmail enviar = new EnviarEmail();
		JTable tabela = janela.getTabela();
		
		int linhaSelecionada = tabela.getSelectedRow();
		String salaLecionada = (String) tabela.getValueAt(linhaSelecionada, 0);
		long idDaSessao = (long) tabela.getValueAt(linhaSelecionada, 6);
		
		for(Sala s: central.recuperarArrayDeSalas()) {
			if(s.getNomeDaSala().equals(salaLecionada)) {
				for(Sessao sessao: s.getSessoes()) {
					if(sessao.getId() == idDaSessao) {
						if(sessao.getDisponivel().equals("Cancelada")) {		
							for(String email:sessao.getEmails()) {
								enviar.enviarEmailCancelandoSessao(email);
							}
						}
					}
				}
			}
		}
		new JanelaControleDeSessoes();
		janela.dispose();
	}

}
