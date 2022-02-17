package janela_home_admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Sistema.CentralDeInformacoes;
import Sistema.Persistencia;
import Sistema.Sala;
import Sistema.Sessao;
import janelas_comum.Janela;
import ouvintes_home_do_admin.OuvinteAbrirJanelaCadastrarSessao;
import ouvintes_home_do_admin.OuvinteCancelarSessao;
import ouvintes_home_do_admin.OuvinteEnviarEmail;
import ouvintes_home_do_admin.OuvinteTabelaSessaoInterromper;
import ouvintes_home_do_admin.OuvinteVoltarHomeAdmin;

public class JanelaControleDeSessoes extends Janela {
	private JTable tabela;
	private DefaultTableModel modelo;
	
	public JanelaControleDeSessoes() {
		adicionarBotao();
		adicionarTabela();
		setTitle("Controle De Sessões");
		setVisible(true);
	}

	private void adicionarTabela() {
		// TODO Auto-generated method stub
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		modelo = new DefaultTableModel();	
		tabela = new JTable(modelo);
		
		modelo.addColumn("Nome");
		modelo.addColumn("Filme");
		modelo.addColumn("Começa às");
		modelo.addColumn("Disponivel");
		modelo.addColumn("Ingressos V.");
		modelo.addColumn("$");
		modelo.addColumn("id");
		
		for(Sala sala: central.recuperarArrayDeSalas()) {
			Object [] linha = new Object[7];
			linha[0] = sala.getNomeDaSala();
			for(Sessao sessao: sala.getSessoes()) {
				linha[1] = sessao.getFilme();
				linha[2] = sessao.getHoraDeInicio();
				linha[3] = sessao.getDisponivel();
				linha[4] = sessao.getIngressosVendidos();
				linha[5] = sessao.getArrecadacao();
				linha[6] = sessao.getId();
				modelo.addRow(linha);
			}
		}
		JScrollPane conteiner = new JScrollPane(tabela);
		conteiner.setBounds(20, 50, 460, 170);
		add(conteiner);
	}
	private void adicionarBotao(){
		JButton btVoltar = new JButton("Volta");
		btVoltar.setBounds(50, 250, 160, 25);
		btVoltar.setOpaque(true);
		btVoltar.setForeground(Color.WHITE);
		btVoltar.setBackground(Color.ORANGE);
		btVoltar.setFont(new Font("Arial", Font.BOLD,18));
		btVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteVoltarHomeAdmin OuvinteVoltar = new OuvinteVoltarHomeAdmin(this);
		btVoltar.addActionListener(OuvinteVoltar);
		add(btVoltar);
		
		JButton btAdicionarSessao = new JButton("Adicionar S.");
		btAdicionarSessao.setBounds(290, 250, 160, 25);
		btAdicionarSessao.setOpaque(true);
		btAdicionarSessao.setForeground(Color.WHITE);
		btAdicionarSessao.setBackground(Color.ORANGE);
		btAdicionarSessao.setFont(new Font("Arial", Font.BOLD,18));
		btAdicionarSessao.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteAbrirJanelaCadastrarSessao ouvinteAdicionarSessao = new OuvinteAbrirJanelaCadastrarSessao(this);
		btAdicionarSessao.addActionListener(ouvinteAdicionarSessao);
		add(btAdicionarSessao);

		JButton btInterromperSessao = new JButton("Interromper S.");
		btInterromperSessao.setBounds(50, 300, 160, 25);
		btInterromperSessao.setOpaque(true);
		btInterromperSessao.setForeground(Color.WHITE);
		btInterromperSessao.setBackground(Color.ORANGE);
		btInterromperSessao.setFont(new Font("Arial", Font.BOLD,18));
		btInterromperSessao.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteTabelaSessaoInterromper ouvinteInterromper = new OuvinteTabelaSessaoInterromper(this);
		btInterromperSessao.addActionListener(ouvinteInterromper);
		add(btInterromperSessao);

		JButton btCancelarSessao = new JButton("Cancelar S.");
		btCancelarSessao.setBounds(290, 300, 160, 25);
		btCancelarSessao.setOpaque(true);
		btCancelarSessao.setForeground(Color.WHITE);
		btCancelarSessao.setBackground(Color.ORANGE);
		btCancelarSessao.setFont(new Font("Arial", Font.BOLD,18));
		btCancelarSessao.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteCancelarSessao ouvinteCancelar = new OuvinteCancelarSessao(this);
		btCancelarSessao.addActionListener(ouvinteCancelar);
		add(btCancelarSessao);
		
	}
	
	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JanelaControleDeSessoes janela = new JanelaControleDeSessoes();
	}
	
}
