package ouvintes_home_do_admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import Sistema.CentralDeInformacoes;
import Sistema.Filme;
import Sistema.Persistencia;
import Sistema.Sala;
import Sistema.Sessao;
import janela_home_admin.JanelaCadastrarSessao;

public class OuvinteSalvarSessao implements ActionListener {
	private JanelaCadastrarSessao janela;

	public OuvinteSalvarSessao(JanelaCadastrarSessao janelaCadastrarSessao) {
		// TODO Auto-generated constructor stub
		janela = janelaCadastrarSessao;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		Sessao sessao = new Sessao();
		Sala salaSelecionada = (Sala) janela.getJcSalas().getSelectedItem();
		Filme filme = (Filme) janela.getJcFilmes().getSelectedItem();
		
		try {
			sessao.setHoraDeInicio(janela.getJfHoraDeInicio().getText());
			sessao.setFilme(filme);
			sessao.setDisponivel("Sim");
			central.checarArray();
			for(Sala sala: central.recuperarArrayDeSalas()) {
				if(sala.getNomeDaSala().equals(salaSelecionada.getNomeDaSala())) {
					sala.checarDisponibilidadeDaSala();
					sala.setSessoesAtivas(1);
					sessao.setVagas(sala.getTotalDeAssentos());
					sala.adicionarSessao(sessao);
				}
			}
			p.salvarCentral(central);
			JOptionPane.showMessageDialog(janela, "Sessão Adicionada");
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(janela, erro.getMessage());
		}
		new JanelaCadastrarSessao();
		janela.dispose();
	}

}
