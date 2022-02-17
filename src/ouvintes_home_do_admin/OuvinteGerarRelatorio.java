package ouvintes_home_do_admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Sistema.GeradorRelatorioEstrategico;
import janela_home_admin.JanelaHomeAdmin;

public class OuvinteGerarRelatorio implements ActionListener {
	private JanelaHomeAdmin janela;
	public OuvinteGerarRelatorio(JanelaHomeAdmin janelaHomeAdmin) {
		// TODO Auto-generated constructor stub
		janela = janelaHomeAdmin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		GeradorRelatorioEstrategico gerar = new GeradorRelatorioEstrategico();
		gerar.gerarDoc();
		JOptionPane.showMessageDialog(janela, "Relatório Gerado");
	}

}
