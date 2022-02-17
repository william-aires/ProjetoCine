package janela_home_admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Sistema.CentralDeInformacoes;
import Sistema.Persistencia;
import Sistema.Sala;
import Sistema.Sessao;
import janelas_comum.Janela;
import ouvintes_home_do_admin.OuvinteVoltarJanelaCadastroSala;

public class JanelaDetalharSalas extends Janela {
	private JTable tabela;
	private String nomeDaSala;
	private int TotalDeAssentos;
	private int frequentacao = 0;
	private String filmesExibidos = "";
	private int sessoesAtivas;
	private float arrecadacao7Dias = 0;
	private float arrecadacao = 0;
	
	
	public JanelaDetalharSalas(String sala){
		this.nomeDaSala = sala;
		adicinarLabels();
		adicionarBotoes();
		setTitle("Detalhes De sala");
		setVisible(true);
	}
	public void adicinarLabels() {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		for(Sala sala: central.recuperarArrayDeSalas()) {
			if(sala.getNomeDaSala().equals(nomeDaSala)) {
				TotalDeAssentos = sala.getTotalDeAssentos();
				sessoesAtivas = sala.getSessoesAtivas();
				for(Sessao sessao: sala.getSessoes()) {
					frequentacao += sessao.getIngressosVendidos();
					filmesExibidos += " " + sessao.getFilme();
					arrecadacao += sessao.getArrecadacao();
					
				}
			}				
		}
		JLabel jbNomeDaSala = new JLabel("Nome Da Sala: " + nomeDaSala);
		jbNomeDaSala.setBounds(30, 70, 300, 20);
		jbNomeDaSala.setForeground(Color.WHITE);
		jbNomeDaSala.setFont(new Font("Arial", Font.BOLD,18));
		add(jbNomeDaSala);
		
		JLabel jbToatalDeAssentos = new JLabel("Total De Assentos: " + TotalDeAssentos);
		jbToatalDeAssentos.setBounds(30, 100, 300, 20);
		jbToatalDeAssentos.setForeground(Color.WHITE);
		jbToatalDeAssentos.setFont(new Font("Arial", Font.BOLD,18));
		add(jbToatalDeAssentos);
		
		JLabel jbToatalDeFrequentacao = new JLabel("Total De Frequentação: " + frequentacao);
		jbToatalDeFrequentacao.setBounds(30, 130, 300, 20);
		jbToatalDeFrequentacao.setForeground(Color.WHITE);
		jbToatalDeFrequentacao.setFont(new Font("Arial", Font.BOLD,18));
		add(jbToatalDeFrequentacao);
		
		JLabel jbFilmesExibidos = new JLabel("Filmes Exibidos: " + filmesExibidos);
		jbFilmesExibidos.setBounds(30, 160, 300, 20);
		jbFilmesExibidos.setForeground(Color.WHITE);
		jbFilmesExibidos.setFont(new Font("Arial", Font.BOLD,18));
		add(jbFilmesExibidos);
		
		JLabel jbSessoesAtivas = new JLabel("Sessões Ativas: " + sessoesAtivas);
		jbSessoesAtivas.setBounds(30, 190, 300, 20);
		jbSessoesAtivas.setForeground(Color.WHITE);
		jbSessoesAtivas.setFont(new Font("Arial", Font.BOLD,18));
		add(jbSessoesAtivas);
		
		JLabel jbArrecadacao7Dias = new JLabel("Arrecadação De 7 Dias: " + arrecadacao7Dias + "R$");
		jbArrecadacao7Dias.setBounds(30, 220, 300, 20);
		jbArrecadacao7Dias.setForeground(Color.WHITE);
		jbArrecadacao7Dias.setFont(new Font("Arial", Font.BOLD,18));
		add(jbArrecadacao7Dias);
		
		JLabel jbArrecadacaoTotal = new JLabel("Arrecadação Total: " + arrecadacao + " R$");
		jbArrecadacaoTotal.setBounds(30, 250, 300, 20);
		jbArrecadacaoTotal.setForeground(Color.WHITE);
		jbArrecadacaoTotal.setFont(new Font("Arial", Font.BOLD,18));
		add(jbArrecadacaoTotal);		
	}
	public void adicionarBotoes() {
		JButton btVoltar = new JButton("Voltar");
		btVoltar.setBounds(200, 300, 100, 30);
		btVoltar.setOpaque(true);
		btVoltar.setForeground(Color.WHITE);
		btVoltar.setBackground(Color.ORANGE);
		btVoltar.setFont(new Font("Arial", Font.BOLD,18));
		btVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteVoltarJanelaCadastroSala ouvinteVoltar = new OuvinteVoltarJanelaCadastroSala(this);
		btVoltar.addActionListener(ouvinteVoltar);
		add(btVoltar);
	}
}
