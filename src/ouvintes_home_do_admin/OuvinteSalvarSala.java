package ouvintes_home_do_admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Sistema.CentralDeInformacoes;
import Sistema.Persistencia;
import Sistema.Sala;
import janela_home_admin.JanelaControleDeSala;

public class OuvinteSalvarSala implements ActionListener{
	private JanelaControleDeSala janela;

	public OuvinteSalvarSala(JanelaControleDeSala janelaCadastroDeSala) {
		// TODO Auto-generated constructor stub
		janela = janelaCadastroDeSala;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		Sala sala = new Sala();
		
		try {
			sala.setNomeDaSala(janela.getTfNomeDaSala().getText());
			sala.setTotalDeAssentos(janela.getJfTotalDeAssentos().getText());
			sala.setPrecoDoIngresso(janela.getJfPrecoDoIngresso().getText());
			sala.setDisponivel("Sim");
			central.adicionarSala(sala);
			p.salvarCentral(central);
			JOptionPane.showMessageDialog(janela, "Sala Cadastrada");
			new JanelaControleDeSala();
			janela.dispose();			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(janela, erro.getMessage());			
		}
		
				
	}

}
