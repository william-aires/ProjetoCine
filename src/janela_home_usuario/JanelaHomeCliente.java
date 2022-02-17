package janela_home_usuario;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Sistema.CentralDeInformacoes;
import Sistema.JtextFieldSomenteNumeros;
import Sistema.Persistencia;
import Sistema.Sala;
import Sistema.Sessao;
import janelas_comum.Janela;
import janelas_comum.JanelaDeLogin;
import ouvintes_home_do_usuario.OuvinteFiltrar;
import ouvintes_home_do_usuario.OuvinteComprarIngresso;
import ouvintes_home_do_usuario.OuvinteExternoSair;
import usuarios.Cliente;
import usuarios.Usuario;

public class JanelaHomeCliente extends Janela{
	private Usuario u;
	private JTable tabela;
	private DefaultTableModel modelo;
	private JComboBox jcFiltro;
	private JtextFieldSomenteNumeros tfQuantidade;
	
	public JanelaHomeCliente(Usuario u) {
		this.u = u;
		setTitle("Bem vindo " + u.getNome());
		adicionarBotoes();
		adicionarTabela();
		adicionarComboBox();
		adicionarLabels();
		adicionarCampo();
		setVisible(true);
		checarSenha();
		repaint();
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
	private void adicionarTabela() {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
	
		modelo = new DefaultTableModel();	
		tabela = new JTable(modelo);
		
		modelo.addColumn("Nome");
		modelo.addColumn("Filme");
		modelo.addColumn("Hora de Inicio");
		modelo.addColumn("Disponivel");
		modelo.addColumn("Vagas");
		modelo.addColumn("Preço");
		modelo.addColumn("id");

		for(Sala sala: central.recuperarArrayDeSalas()) {
			for(Sessao sessao: sala.getSessoes()) {
				Object [] linha = new Object[7];
				linha[0] = sala.getNomeDaSala();
				linha[1] = sessao.getFilme();
				linha[2] = sessao.getHoraDeInicio();
				linha[3] = sessao.getDisponivel();
				linha[4] = sessao.getVagas();
				linha[5] = sala.getPrecoDoIngresso();
				linha[6] = sessao.getId();
				modelo.addRow(linha);
			}
		}
		JScrollPane conteiner = new JScrollPane(tabela);
		conteiner.setBounds(20, 90, 460, 170);
		add(conteiner);
	}
	private void adicionarCampo() {
		tfQuantidade = new JtextFieldSomenteNumeros();
		tfQuantidade.setBounds(135, 300, 50, 25);
		tfQuantidade.setOpaque(true);
		tfQuantidade.setBackground(Color.LIGHT_GRAY);
		tfQuantidade.setForeground(Color.BLACK);
		tfQuantidade.setFont(new Font("Arial", Font.BOLD,15));
		add(tfQuantidade);
	}
	
	private void adicionarLabels() {
		JLabel lbQuantIngressos = new JLabel ("Quantidade:");
		lbQuantIngressos.setBounds(20, 300, 120, 25);
		lbQuantIngressos.setForeground(Color.WHITE);
		lbQuantIngressos.setFont(new Font("Arial", Font.BOLD,18));
		add(lbQuantIngressos);
	}
	
	private void adicionarBotoes() {
		JButton btFiltrar = new JButton("OK");
		btFiltrar.setBounds(390,55, 80, 25);
		btFiltrar.setOpaque(true);
		btFiltrar.setForeground(Color.WHITE);
		btFiltrar.setBackground(Color.ORANGE);
		btFiltrar.setFont(new Font("Arial", Font.BOLD,18));
		btFiltrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteFiltrar ouvinteFiltro = new OuvinteFiltrar(this);
		btFiltrar.addActionListener(ouvinteFiltro);
		add(btFiltrar);
		
		JButton btComprarIngresso = new JButton("Comprar");
		btComprarIngresso.setBounds(200,300, 120, 25);
		btComprarIngresso.setOpaque(true);
		btComprarIngresso.setForeground(Color.WHITE);
		btComprarIngresso.setBackground(Color.ORANGE);
		btComprarIngresso.setFont(new Font("Arial", Font.BOLD,18));
		btComprarIngresso.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteComprarIngresso ouvinteComprar = new OuvinteComprarIngresso(this);
		btComprarIngresso.addActionListener(ouvinteComprar);
		add(btComprarIngresso);
		
		JButton btSair = new JButton("Sair");
		btSair.setBounds(350,300, 100, 25);
		btSair.setOpaque(true);
		btSair.setForeground(Color.WHITE);
		btSair.setBackground(Color.ORANGE);
		btSair.setFont(new Font("Arial", Font.BOLD,18));
		btSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
		OuvinteExternoSair ouvinteSair = new OuvinteExternoSair(this);
		btSair.addActionListener(ouvinteSair);
		add(btSair);
	}
	public void adicionarComboBox() {
		String[] filtro = {"Filtra por:", "Ativas","Todas"};
		jcFiltro = new JComboBox<String>(filtro);
		jcFiltro.setBounds(270,55, 110, 25);
		jcFiltro.setOpaque(true);
		jcFiltro.setForeground(Color.BLACK);
		jcFiltro.setBackground(Color.LIGHT_GRAY);
		jcFiltro.setFont(new Font("Arial", Font.BOLD,18));
		jcFiltro.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(jcFiltro);
		
	}

	public JtextFieldSomenteNumeros getTfQuantidade() {
		return tfQuantidade;
	}
	public void setTfQuantidade(JtextFieldSomenteNumeros tfQuantidade) {
		this.tfQuantidade = tfQuantidade;
	}
	public JComboBox getJcFiltro() {
		return jcFiltro;
	}
	public void setJcFiltro(JComboBox jcFiltro) {
		this.jcFiltro = jcFiltro;
	}
	public Usuario getU() {
		return u;
	}
	public void setU(Usuario u) {
		this.u = u;
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
	public static void main(String [] args) {
	}

}
