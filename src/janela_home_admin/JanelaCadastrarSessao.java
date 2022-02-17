package janela_home_admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Sistema.CentralDeInformacoes;
import Sistema.Filme;
import Sistema.Persistencia;
import Sistema.Sala;
import janelas_comum.Janela;
import ouvintes_home_do_admin.OuvinteSalvarSessao;
import ouvintes_home_do_admin.OuvinteVoltarJanelaControleDeSessoes;

public class JanelaCadastrarSessao extends Janela {
	private JFormattedTextField jfHoraDeInicio;
	private JComboBox<Filme> jcFilmes;
	private JComboBox<Sala> jcSalas;
	
	private JLabel lbExibicao1;
	public JLabel getLbExibicao1() {
		return lbExibicao1;
	}
	public void setLbExibicao1(JLabel lbExibicao1) {
		this.lbExibicao1 = lbExibicao1;
	}
	
	
	public JanelaCadastrarSessao() {
		adicionarLabels();
		adicionarBotoes();
		adicionarCampo();
		adicionarComboBox();
		setTitle("Cadastrar Sessão");
		setVisible(true);
	}
	private void adicionarComboBox() {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();

		jcFilmes = new JComboBox<Filme>();
		for(Filme filme: central.getFilmes()) 
			jcFilmes.addItem(filme);
		jcFilmes.setBounds(290, 100, 100, 30);
		jcFilmes.setOpaque(true);
		jcFilmes.setForeground(Color.BLACK);
		jcFilmes.setBackground(Color.LIGHT_GRAY);
		jcFilmes.setFont(new Font("Arial", Font.BOLD,18));
		jcFilmes.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(jcFilmes);
		
		jcSalas = new JComboBox<Sala>();
		for(Sala sala: central.recuperarArrayDeSalas()) 
			jcSalas.addItem(sala);
		jcSalas.setBounds(290, 150, 100, 30);
		jcSalas.setOpaque(true);
		jcSalas.setForeground(Color.BLACK);
		jcSalas.setBackground(Color.LIGHT_GRAY);
		jcSalas.setFont(new Font("Arial", Font.BOLD,18));
		jcSalas.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(jcSalas);
	}
	
	private void adicionarLabels() {
		JLabel lbHoraDeInicio = new JLabel("Inícia ás:");
		lbHoraDeInicio.setBounds(80, 100, 100, 20);
		lbHoraDeInicio.setForeground(Color.WHITE);
		lbHoraDeInicio.setFont(new Font("Arial", Font.BOLD,18));
		add(lbHoraDeInicio);

	}
	
	private void adicionarBotoes() {
		// TODO Auto-generated method stub
		JButton btCadastrar = new JButton("Cadastrar S.");
		btCadastrar.setBounds(50, 250, 150, 30);
		btCadastrar.setOpaque(true);
		btCadastrar.setForeground(Color.WHITE);
		btCadastrar.setBackground(Color.ORANGE);
		btCadastrar.setFont(new Font("Arial", Font.BOLD,18));
		btCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteSalvarSessao ouvinteSalvar = new OuvinteSalvarSessao(this);
		btCadastrar.addActionListener(ouvinteSalvar);
		add(btCadastrar);
		
		JButton btVoltar = new JButton("Voltar");
		btVoltar.setBounds(300, 250, 150, 30);
		btVoltar.setOpaque(true);
		btVoltar.setForeground(Color.WHITE);
		btVoltar.setBackground(Color.ORANGE);
		btVoltar.setFont(new Font("Arial", Font.BOLD,18));
		btVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteVoltarJanelaControleDeSessoes ouvinteVoltar = new OuvinteVoltarJanelaControleDeSessoes(this);
		btVoltar.addActionListener(ouvinteVoltar);
		add(btVoltar);
	}

	private void adicionarCampo() {
		// TODO Auto-generated method stub
		try {
			MaskFormatter mascara = new MaskFormatter("##:##");
			jfHoraDeInicio = new JFormattedTextField(mascara);
			jfHoraDeInicio.setBounds(170, 100, 100, 30);
			jfHoraDeInicio.setOpaque(true);
			jfHoraDeInicio.setBackground(Color.LIGHT_GRAY);
			jfHoraDeInicio.setForeground(Color.BLACK);
			jfHoraDeInicio.setFont(new Font("Arial", Font.BOLD,15));
			add(jfHoraDeInicio);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public JFormattedTextField getJfHoraDeInicio() {
		return jfHoraDeInicio;
	}
	public void setJfHoraDeInicio(JFormattedTextField jfHoraDeInicio) {
		this.jfHoraDeInicio = jfHoraDeInicio;
	}
	public JComboBox<Filme> getJcFilmes() {
		return jcFilmes;
	}
	public void setJcFilmes(JComboBox<Filme> jcFilmes) {
		this.jcFilmes = jcFilmes;
	}
	public JComboBox<Sala> getJcSalas() {
		return jcSalas;
	}
	public void setJcSalas(JComboBox<Sala> jcSalas) {
		this.jcSalas = jcSalas;
	}
	public static void main (String[]args) {
		new JanelaCadastrarSessao();
	}

}
