package janela_home_admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Sistema.CentralDeInformacoes;
import Sistema.Persistencia;
import janelas_comum.Janela;
import ouvintes_home_do_admin.OuvinteAbrirJanelaCadastrarFilme;
import ouvintes_home_do_admin.OuvinteAbrirJanelaCadastroSala;
import ouvintes_home_do_admin.OuvinteAbrirJanelaControleDeSessoes;
import ouvintes_home_do_admin.OuvinteGerarRelatorio;
import ouvintes_home_do_admin.OuvinteSair;
import usuarios.Usuario;

/**
 * @author 201825020013
 *
 */
public class JanelaHomeAdmin extends Janela {
	private Usuario u;
	public JanelaHomeAdmin(Usuario u) {
		this.u = u;
		setTitle("Bem Vindo " + u.getNome());
		adicionarBotoes();
		setVisible(true);
		checarSenha();
	}
	public void checarSenha() {
		if(u.getSenha().equals("1234")) {
			Persistencia p = new Persistencia();
			CentralDeInformacoes central = p.recuperarCentral();
			boolean deuCerto = false;
			String novaSenha;
			while(!deuCerto) {
				if(u.getSenha().equals("1234")) {
					novaSenha = JOptionPane.showInputDialog("Atualize a senha");
					if(novaSenha == null) {
						continue;
					}
					else if(!novaSenha.isEmpty()) {
						for(Usuario usu: central.getUsuarios())
							if(usu.getEmail().equals(u.getEmail())) {
								usu.setSenha(novaSenha);
								JOptionPane.showMessageDialog(null, "Deu Certo");
								deuCerto = true;
								p.salvarCentral(central);
							}
					}else if(novaSenha.isEmpty())
						JOptionPane.showMessageDialog(null, "Digite a nova senha!");	
				}	
			}
		}
	}

	public void adicionarBotoes() {
		// BOTÕES DE SALAS
		JButton btCadastrarSala = new JButton("Controle De Salas");
		btCadastrarSala.setBounds(135, 90, 225, 25);
		btCadastrarSala.setOpaque(true);
		btCadastrarSala.setForeground(Color.WHITE);
		btCadastrarSala.setBackground(Color.ORANGE);
		btCadastrarSala.setFont(new Font("Arial", Font.BOLD,18));
		btCadastrarSala.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteAbrirJanelaCadastroSala ouvinteAbrirJanelaCadastrarSala = new OuvinteAbrirJanelaCadastroSala(this); 
		btCadastrarSala.addActionListener(ouvinteAbrirJanelaCadastrarSala);
		add(btCadastrarSala);
		
		// BOTÕES DA SESSÃO
		JButton btListarSessoes = new JButton("Controle De Sessões");
		btListarSessoes.setBounds(135, 140, 225, 25);
		btListarSessoes.setOpaque(true);
		btListarSessoes.setForeground(Color.WHITE);
		btListarSessoes.setBackground(Color.ORANGE);
		btListarSessoes.setFont(new Font("Arial", Font.BOLD,18));
		btListarSessoes.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteAbrirJanelaControleDeSessoes ouvinteAbrir = new OuvinteAbrirJanelaControleDeSessoes(this);
		btListarSessoes.addActionListener(ouvinteAbrir);
		add(btListarSessoes);

		// BOTÕES DE FILMES
		JButton btCadastrarFilme = new JButton("Cadastrar Filme");
		btCadastrarFilme.setBounds(135, 190, 225, 25);
		btCadastrarFilme.setOpaque(true);
		btCadastrarFilme.setForeground(Color.WHITE);
		btCadastrarFilme.setBackground(Color.ORANGE);
		btCadastrarFilme.setFont(new Font("Arial", Font.BOLD,18));
		btCadastrarFilme.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteAbrirJanelaCadastrarFilme ouvinteCadastrarFilme = new OuvinteAbrirJanelaCadastrarFilme(this);
		btCadastrarFilme.addActionListener(ouvinteCadastrarFilme);
		add(btCadastrarFilme);

		JButton btGerarRelatorio = new JButton("Gerar Relatório");
		btGerarRelatorio.setBounds(135, 240, 225, 25);
		btGerarRelatorio.setOpaque(true);
		btGerarRelatorio.setForeground(Color.WHITE);
		btGerarRelatorio.setBackground(Color.ORANGE);
		btGerarRelatorio.setFont(new Font("Arial", Font.BOLD,18));
		btGerarRelatorio.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteGerarRelatorio ouvinteGerar = new OuvinteGerarRelatorio(this);
		btGerarRelatorio.addActionListener(ouvinteGerar);
		add(btGerarRelatorio);

		// BOTÃO DE SAIR
		JButton btSair = new JButton("Sair");
		btSair.setBounds(135, 290, 225, 25);
		btSair.setOpaque(true);
		btSair.setForeground(Color.WHITE);
		btSair.setBackground(Color.ORANGE);
		btSair.setFont(new Font("Arial", Font.BOLD,18));
		btGerarRelatorio.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteSair ouvinteSair = new OuvinteSair(this);
		btSair.addActionListener(ouvinteSair);
		add(btSair);
	}
	public Usuario getU() {
		return u;
	}
	public void setU(Usuario u) {
		this.u = u;
	}
	

}
