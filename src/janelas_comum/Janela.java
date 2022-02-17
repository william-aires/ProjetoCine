package janelas_comum;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Janela extends JFrame {
	
	public Janela() {
		configurarJanela();
		adicionarLabels();
	}
	private void configurarJanela() {
		setSize(500,400);
		setLocationRelativeTo(null);
		setLayout(null);
		setTitle("CINE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.DARK_GRAY);
		//setVisible(true);

	}
	
	private void adicionarLabels() {	
		JLabel titulo = new JLabel("CINE MONTEIRO");
		titulo.setBounds(190, 0, 130, 40);
		titulo.setFont(new Font("Arial",Font.BOLD,16));
		titulo.setForeground(Color.WHITE);
		add(titulo);
		
		JLabel lbFaixa = new JLabel();
		lbFaixa.setBounds(0, 0, 500, 40);	
		lbFaixa.setOpaque(true);
		lbFaixa.setBackground(Color.ORANGE);
		add(lbFaixa);
		
//		JLabel lbCorDeFundo = new JLabel();
//		lbCorDeFundo.setBounds(0, 0, 400, 300);	
//		lbCorDeFundo.setOpaque(true);
//		lbCorDeFundo.setBackground(Color.BLACK);
//		add(lbCorDeFundo);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Janela janela = new Janela();
	}

}
