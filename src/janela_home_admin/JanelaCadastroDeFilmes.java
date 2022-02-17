package janela_home_admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Sistema.CentralDeInformacoes;
import Sistema.JtextFieldSomenteNumeros;
import Sistema.Persistencia;
import Sistema.Sala;
import janelas_comum.Janela;
import ouvintes_home_do_admin.OuvinteSalvarFilme;
import ouvintes_home_do_admin.OuvinteVoltarHomeAdmin;

public class JanelaCadastroDeFilmes extends Janela {
	private JTextArea taSinopse;
	private JTextField tfTitulo;
	private JComboBox<String> cbGeneros;
	private JComboBox<String> cbClassificacaoIndicativa;
	
	private JFormattedTextField jftfEmCartazAte;
	private JtextFieldSomenteNumeros jfDuracao;

	public JanelaCadastroDeFilmes() {
		adicionarLabels();
		adicionarCampoDeTexto();
		adicionarBotões();
		adicionarComboBox();
		setTitle("Cadastrar Filme");
		setVisible(true);
	}

	private void adicionarComboBox() {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		
		String[] generos = { "Acao", "Romance", "Terror", "Drama", "Comedia", "Animacao", "Aventura", "Suspense",
				"Documentario", "Fantasia", "Ficção Cientifica", "Faroeste" };
		cbGeneros = new JComboBox<String>(generos);
		cbGeneros.setBounds(330, 200, 110, 25);
		cbGeneros.setOpaque(true);
		cbGeneros.setForeground(Color.BLACK);
		cbGeneros.setBackground(Color.LIGHT_GRAY);
		cbGeneros.setFont(new Font("Arial", Font.BOLD,18));
		cbGeneros.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(cbGeneros);
		
		String[]classificacaoIndicativa = {"Livre","10","12","14","16","18"};
		cbClassificacaoIndicativa = new JComboBox<String>(classificacaoIndicativa);
		cbClassificacaoIndicativa.setBounds(330, 230, 110, 25);
		cbClassificacaoIndicativa.setOpaque(true);
		cbClassificacaoIndicativa.setForeground(Color.BLACK);
		cbClassificacaoIndicativa.setBackground(Color.LIGHT_GRAY);
		cbClassificacaoIndicativa.setFont(new Font("Arial", Font.BOLD,18));
		cbClassificacaoIndicativa.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(cbClassificacaoIndicativa);
		
	}
	
	private void adicionarBotões() {
		JButton btSalvarFilme = new JButton("Cadastrar F.");
		btSalvarFilme.setBounds(60, 300, 140, 25);
		btSalvarFilme.setOpaque(true);
		btSalvarFilme.setForeground(Color.WHITE);
		btSalvarFilme.setBackground(Color.ORANGE);
		btSalvarFilme.setFont(new Font("Arial", Font.BOLD,18));
		btSalvarFilme.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteSalvarFilme ouvinteSalvar = new OuvinteSalvarFilme(this);
		btSalvarFilme.addActionListener(ouvinteSalvar);
		add(btSalvarFilme);
		
		JButton btVoltar = new JButton("Voltar");
		btVoltar.setBounds(300, 300, 140, 25);
		btVoltar.setOpaque(true);
		btVoltar.setForeground(Color.WHITE);
		btVoltar.setBackground(Color.ORANGE);
		btVoltar.setFont(new Font("Arial", Font.BOLD,18));
		btVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteVoltarHomeAdmin ouvinteVoltar = new OuvinteVoltarHomeAdmin(this);
		btVoltar.addActionListener(ouvinteVoltar);
		add(btVoltar);
	}

	private void adicionarCampoDeTexto() {
		try {
			MaskFormatter mascara1 = new MaskFormatter("##/##/####");
			jftfEmCartazAte = new JFormattedTextField(mascara1);
			jftfEmCartazAte.setBounds(150, 230, 80, 25);
			jftfEmCartazAte.setOpaque(true);
			jftfEmCartazAte.setBackground(Color.LIGHT_GRAY);
			jftfEmCartazAte.setForeground(Color.BLACK);
			jftfEmCartazAte.setFont(new Font("Arial", Font.BOLD,15));
			add(jftfEmCartazAte);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(140, 70, 200, 25);
		tfTitulo.setOpaque(true);
		tfTitulo.setBackground(Color.LIGHT_GRAY);
		tfTitulo.setForeground(Color.BLACK);
		tfTitulo.setFont(new Font("Arial", Font.BOLD,15));
		add(tfTitulo);
		
		taSinopse = new JTextArea();
		taSinopse.setBounds(140, 110, 300, 70);
		taSinopse.setOpaque(true);
		taSinopse.setBackground(Color.LIGHT_GRAY);
		taSinopse.setForeground(Color.BLACK);
		taSinopse.setFont(new Font("Arial", Font.BOLD,15));
		taSinopse.setLineWrap(true);
		taSinopse.setWrapStyleWord(true);
		add(taSinopse);
		
		jfDuracao = new JtextFieldSomenteNumeros();
		jfDuracao.setBounds(140, 200, 50, 25);
		jfDuracao.setOpaque(true);
		jfDuracao.setBackground(Color.LIGHT_GRAY);
		jfDuracao.setForeground(Color.BLACK);
		jfDuracao.setFont(new Font("Arial", Font.BOLD,15));
		add(jfDuracao);
	}

	private void adicionarLabels() {
		JLabel lbTitulo = new JLabel("Titulo:");
		lbTitulo.setBounds(50, 70, 100, 25);
		lbTitulo.setForeground(Color.WHITE);
		lbTitulo.setFont(new Font("Arial", Font.BOLD,18));
		add(lbTitulo);

		JLabel lbSinopse = new JLabel("Sinopse:");
		lbSinopse.setBounds(50, 110, 100, 25);
		lbSinopse.setForeground(Color.WHITE);
		lbSinopse.setFont(new Font("Arial", Font.BOLD,18));
		add(lbSinopse);

		JLabel lbGenero = new JLabel("Gênero:");
		lbGenero.setBounds(250, 200, 100, 25);
		lbGenero.setForeground(Color.WHITE);
		lbGenero.setFont(new Font("Arial", Font.BOLD,18));
		add(lbGenero);

		JLabel lbDuracao = new JLabel("Duração:");
		lbDuracao.setBounds(50, 200, 100, 25);
		lbDuracao.setForeground(Color.WHITE);
		lbDuracao.setFont(new Font("Arial", Font.BOLD,18));
		add(lbDuracao);

		JLabel lbClassificação = new JLabel("Classifi.:");
		lbClassificação.setBounds(250, 230, 120, 25);
		lbClassificação.setForeground(Color.WHITE);
		lbClassificação.setFont(new Font("Arial", Font.BOLD,18));
		add(lbClassificação);
		
		JLabel lbEmCartazAte = new JLabel("Cartaz Até:");
		lbEmCartazAte.setBounds(50, 230, 100, 25);
		lbEmCartazAte.setForeground(Color.WHITE);
		lbEmCartazAte.setFont(new Font("Arial", Font.BOLD,18));
		add(lbEmCartazAte);
		
	}

	public JTextField getTfTitulo() {
		return tfTitulo;
	}

	public void setTfTitulo(JTextField tfTitulo) {
		this.tfTitulo = tfTitulo;
	}

	public JTextArea getTaSinopse() {
		return taSinopse;
	}

	public void setTaSinopse(JTextArea taSinopse) {
		this.taSinopse = taSinopse;
	}

	public JComboBox<String> getCbGeneros() {
		return cbGeneros;
	}

	public void setCbGeneros(JComboBox<String> cbGeneros) {
		this.cbGeneros = cbGeneros;
	}

	public JComboBox<String> getCbClassificacaoIndicativa() {
		return cbClassificacaoIndicativa;
	}

	public void setCbClassificacaoIndicativa(JComboBox<String> cbClassificacaoIndicativa) {
		this.cbClassificacaoIndicativa = cbClassificacaoIndicativa;
	}

	public JFormattedTextField getJftfEmCartazAte() {
		return jftfEmCartazAte;
	}
	public void setJftfEmCartazAte(JFormattedTextField jftfEmCartazAte) {
		this.jftfEmCartazAte = jftfEmCartazAte;
	}
	public JtextFieldSomenteNumeros getJfDuracao() {
		return jfDuracao;
	}
	public void setJfDuracao(JtextFieldSomenteNumeros jfDuracao) {
		this.jfDuracao = jfDuracao;
	}
	
	
	public static void main(String[] args) {
		JanelaCadastroDeFilmes janela = new JanelaCadastroDeFilmes();

	}

}
