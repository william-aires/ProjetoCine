package ouvintes_home_do_usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import Sistema.CentralDeInformacoes;
import Sistema.GerarBoleto;
import Sistema.Persistencia;
import Sistema.Sala;
import Sistema.Sessao;
import janela_home_admin.JanelaControleDeSessoes;
import janela_home_usuario.JanelaHomeCliente;

public class OuvinteComprarIngresso implements ActionListener {
	private JanelaHomeCliente janela;
	public OuvinteComprarIngresso(JanelaHomeCliente janelaHomeCliente) {
		// TODO Auto-generated constructor stub
		janela = janelaHomeCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		JTable tabela = janela.getTabela();
		float valorDaCompra;
		
		int linhaSelecionada = tabela.getSelectedRow();
		String salaLecionada = (String) tabela.getValueAt(linhaSelecionada, 0);
		long idSelecionada = (long) tabela.getValueAt(linhaSelecionada, 6);
		try {
			for(Sala sala: central.recuperarArrayDeSalas()){
				if(sala.getNomeDaSala().equals(salaLecionada))
					for(Sessao sessao: sala.getSessoes()){
						if(sessao.getId() == idSelecionada){
							sessao.comprarIngresso(janela.getTfQuantidade().getText());
							sessao.setArrecadacao(Float.parseFloat(janela.getTfQuantidade().getText()) * sala.getPrecoDoIngresso());
							valorDaCompra = Float.parseFloat(janela.getTfQuantidade().getText()) * sala.getPrecoDoIngresso();
							sessao.adicionarEmailDoComprador(janela.getU().getEmail());
							sala.setArrecadacao(valorDaCompra);
							
							if(sessao.getVagas() == 0){
								sessao.setDisponivel("nao");
								sala.sessoesAtivas(1);
							}
							p.salvarCentral(central);
							JOptionPane.showMessageDialog(janela, "Ingressos Comprados");
							GerarBoleto gerar = new GerarBoleto();
							gerar.gerarDoc(valorDaCompra, janela.getU().getNome());
							
						}
					}		
			}
			new JanelaHomeCliente(janela.getU());
			janela.dispose();
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(janela, erro.getMessage());
		}							
		
	}

}
