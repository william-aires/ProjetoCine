package ouvintes_home_do_admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Sistema.CentralDeInformacoes;
import Sistema.Filme;
import Sistema.Persistencia;
import Sistema.Sala;
import Sistema.Sessao;
import janela_home_admin.JanelaCadastroDeFilmes;

public class OuvinteSalvarFilme implements ActionListener{
	private JanelaCadastroDeFilmes janela;

	public OuvinteSalvarFilme(JanelaCadastroDeFilmes janelaCadastroDeFilmes) {
		// TODO Auto-generated constructor stub
		janela = janelaCadastroDeFilmes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		Filme filme = new Filme();
		Sessao sessao = new Sessao();
		
		try{
			filme.setNomeDoFilme(janela.getTfTitulo().getText());
			filme.setSinopse(janela.getTaSinopse().getText());
			filme.setClassificacaoEtaria(((String) janela.getCbClassificacaoIndicativa().getSelectedItem()));
			filme.setGenero((String)janela.getCbGeneros().getSelectedItem());
			filme.setEmCartazAte(janela.getJftfEmCartazAte().getText());
			filme.setDuracaoDoFilme(janela.getJfDuracao().getText());
			central.adicionarFilme(filme);
			JOptionPane.showMessageDialog(janela, "Filme Cadastrado");
			p.salvarCentral(central);
			new JanelaCadastroDeFilmes();
			janela.dispose();
		}catch(Exception erro){
			JOptionPane.showMessageDialog(janela, erro.getMessage());
		}
		
	}

}
