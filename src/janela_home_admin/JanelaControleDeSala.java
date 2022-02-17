package janela_home_admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Scrollbar;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Sistema.CentralDeInformacoes;
import Sistema.JtextFieldSomenteNumeros;
import Sistema.Persistencia;
import Sistema.Sala;
import janelas_comum.Janela;
import ouvintes_comum.OuvinteExternoVoltar;
import ouvintes_home_do_admin.OuvinteAbrirDetalharSala;
import ouvintes_home_do_admin.OuvinteExcluirSala;
import ouvintes_home_do_admin.OuvinteSalvarSala;
import ouvintes_home_do_admin.OuvinteVoltarHomeAdmin;
import usuarios.Usuario;

public class JanelaControleDeSala extends Janela{
	private JTextField tfNomeDaSala;
	private JtextFieldSomenteNumeros jfTotalDeAssentos;
	private JFormattedTextField jfPrecoDoIngresso;
	private JTable tabela;
	private JComboBox<Sala> cbDeSalas;
	
	public JanelaControleDeSala() {
		adicionarLabels();
		adicionarCampos();
		adicionarBotoes();
		adicionarTabela();
		setTitle("Controle De Salas");
		repaint();
		setVisible(true);
	}
	
	private void adicionarTabela() {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		DefaultTableModel modelo = new DefaultTableModel();	
		tabela = new JTable(modelo);
		
		modelo.addColumn("Sala");
		modelo.addColumn("Preço do Ingresso");
		modelo.addColumn("Vagas");
		modelo.addColumn("Disponivel");
		modelo.addColumn("Sessões Ativas");
		modelo.addColumn("Id");
		
		for(Sala sala: central.recuperarArrayDeSalas()) {
			Object [] linha = new Object[6];
			linha[0] = sala.getNomeDaSala();
			linha[1] = sala.getPrecoDoIngresso();
			linha[2] = sala.getTotalDeAssentos();
			linha[3] = sala.getDisponivel();
			linha[4] = sala.getSessoesAtivas();
			linha[5] = sala.getId();
			modelo.addRow(linha);
		}
		JScrollPane conteiner = new JScrollPane(tabela);
		conteiner.setBounds(20, 150, 450, 170);
		add(conteiner);
	}
	
	private void adicionarBotoes() {
		JButton btSalvar = new JButton("Cadastrar");
		btSalvar.setBounds(340, 100, 120, 25);
		btSalvar.setOpaque(true);
		btSalvar.setForeground(Color.WHITE);
		btSalvar.setBackground(Color.ORANGE);
		btSalvar.setFont(new Font("Arial", Font.BOLD,18));
		btSalvar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteSalvarSala ouvinteSalvarSala = new OuvinteSalvarSala(this);
		btSalvar.addActionListener(ouvinteSalvarSala);
		add(btSalvar);
		
		JButton btVoltar = new JButton("Voltar");
		btVoltar.setBounds(340, 60, 120, 25);
		btVoltar.setOpaque(true);
		btVoltar.setForeground(Color.WHITE);
		btVoltar.setBackground(Color.ORANGE);
		btVoltar.setFont(new Font("Arial", Font.BOLD,18));
		btVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteVoltarHomeAdmin ouvinteVoltar = new OuvinteVoltarHomeAdmin(this);
		btVoltar.addActionListener(ouvinteVoltar);
		add(btVoltar);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.setBounds(220, 335, 100, 25);
		btExcluir.setOpaque(true);
		btExcluir.setForeground(Color.WHITE);
		btExcluir.setBackground(Color.ORANGE);
		btExcluir.setFont(new Font("Arial", Font.BOLD,18));
		btExcluir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteExcluirSala ouvinteExcluir =  new OuvinteExcluirSala(this);
		btExcluir.addActionListener(ouvinteExcluir);
		add(btExcluir);
		
		JButton btDetalharSala = new JButton("Detalhar");
		btDetalharSala.setBounds(350, 335, 120, 25);
		btDetalharSala.setOpaque(true);
		btDetalharSala.setForeground(Color.WHITE);
		btDetalharSala.setBackground(Color.ORANGE);
		btDetalharSala.setFont(new Font("Arial", Font.BOLD,18));
		btDetalharSala.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteAbrirDetalharSala ouvinteDetalhar = new OuvinteAbrirDetalharSala(this);
		btDetalharSala.addActionListener(ouvinteDetalhar);
		add(btDetalharSala);
		
	}

	private void adicionarCampos() {
		// TODO Auto-generated method stub
		tfNomeDaSala = new JTextField();
		tfNomeDaSala.setBounds(195,50,100,20);
		tfNomeDaSala.setOpaque(true);
		tfNomeDaSala.setBackground(Color.LIGHT_GRAY);
		tfNomeDaSala.setForeground(Color.BLACK);
		tfNomeDaSala.setFont(new Font("Arial", Font.BOLD,15));
		add(tfNomeDaSala);
		
		jfTotalDeAssentos = new JtextFieldSomenteNumeros();
		jfTotalDeAssentos.setBounds(195,80,100,20);
		jfTotalDeAssentos.setOpaque(true);
		jfTotalDeAssentos.setBackground(Color.LIGHT_GRAY);
		jfTotalDeAssentos.setForeground(Color.BLACK);
		jfTotalDeAssentos.setFont(new Font("Arial", Font.BOLD,15));
		add(jfTotalDeAssentos);
		
		try {
			MaskFormatter mascara = new MaskFormatter("##.##");
			jfPrecoDoIngresso = new JFormattedTextField(mascara);
			jfPrecoDoIngresso.setBounds(195,110,100,20);
			jfPrecoDoIngresso.setBackground(Color.LIGHT_GRAY);
			jfPrecoDoIngresso.setForeground(Color.BLACK);
			jfPrecoDoIngresso.setFont(new Font("Arial", Font.BOLD,15));
			add(jfPrecoDoIngresso);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	private void adicionarLabels() {
		JLabel lbNomeDaSala = new JLabel("Nome Da Sala:");
		lbNomeDaSala.setBounds(40, 50, 130, 20);
		lbNomeDaSala.setForeground(Color.WHITE);
		lbNomeDaSala.setFont(new Font("Arial", Font.BOLD,17));
		add(lbNomeDaSala);
		
		JLabel lbTotalDeAssentos = new JLabel("Total De Assentos:");
		lbTotalDeAssentos.setBounds(40,80,165,20);
		lbTotalDeAssentos.setForeground(Color.WHITE);
		lbTotalDeAssentos.setFont(new Font("Arial", Font.BOLD,17));
		add(lbTotalDeAssentos);
		
		JLabel lbPreçoDoIngresso = new JLabel("Preço do Ingresso:");
		lbPreçoDoIngresso.setBounds(40,110,165,20);
		lbPreçoDoIngresso.setForeground(Color.WHITE);
		lbPreçoDoIngresso.setFont(new Font("Arial", Font.BOLD,17));
		add(lbPreçoDoIngresso);
		
	}

	public JTextField getTfNomeDaSala() {
		return tfNomeDaSala;
	}

	public void setTfNomeDaSala(JTextField tfNomeDaSala) {
		this.tfNomeDaSala = tfNomeDaSala;
	}

	public JComboBox<Sala> getCbDeSalas() {
		return cbDeSalas;
	}

	public void setCbDeSalas(JComboBox<Sala> cbDeSalas) {
		this.cbDeSalas = cbDeSalas;
	}

	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}

	public JFormattedTextField getJfPrecoDoIngresso() {
		return jfPrecoDoIngresso;
	}

	public void setJfPrecoDoIngresso(JFormattedTextField jfPrecoDoIngresso) {
		this.jfPrecoDoIngresso = jfPrecoDoIngresso;
	}

	public JtextFieldSomenteNumeros getJfTotalDeAssentos() {
		return jfTotalDeAssentos;
	}

	public void setJfTotalDeAssentos(JtextFieldSomenteNumeros jfTotalDeAssentos) {
		this.jfTotalDeAssentos = jfTotalDeAssentos;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JanelaControleDeSala janela = new JanelaControleDeSala();
	}

}
