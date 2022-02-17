package Sistema;
import java.util.ArrayList;

public class Sessao {
	private Filme filme;
	private String horaDeInicio;
	private String disponivel;
	private int ingressosVendidos;
	private float arrecadacao;
	private long id;
	private int vagas;
	private ArrayList<String>emails = new ArrayList<String>();
	
	public Sessao(){
		id = System.currentTimeMillis();
	}
	
	public String getHoraDeInicio() {
		return horaDeInicio;
	}

	public void setHoraDeInicio(String horaDeInicio) throws Exception {
		if(horaDeInicio.equals("  :  "))
			throw new Exception("Digite a Hora De inicio");
		this.horaDeInicio = horaDeInicio;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) throws Exception{
		if(filme == null) {
			throw new Exception("Filme não Cadastrado");
		}
		this.filme = filme;
	}

	public String getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}

	public int getIngressosVendidos() {
		return ingressosVendidos;
	}

	public void setIngressosVendidos(int ingressosVendidos) {
		this.ingressosVendidos += ingressosVendidos;
	}

	public float getArrecadacao() {
		return arrecadacao;
	}

	public void setArrecadacao(float arrecadacao) {
		this.arrecadacao += arrecadacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}
	public void adicionarEmailDoComprador(String email) {
		for(String e: emails) {
			if(e.equals(email)) {
				return;
			}
		}
		emails.add(email);
	}
	
	public ArrayList<String> getEmails() {
		return emails;
	}

	public void setEmails(ArrayList<String> emails) {
		this.emails = emails;
	}

	public void comprarIngresso(String ingre) throws Exception {
		if(ingre.isEmpty()) {
			throw new Exception("Digite a Quantidade");
		}
		int ingresso = Integer.parseInt(ingre);
		
		if(ingresso > vagas) {
			throw new Exception("Você só pode comprar " + vagas + " Ingresso para esta sessão");
		}
		else if(ingresso == 0) {
			throw new Exception("Digite um número diferente de 0");	
		}
		else if(vagas == 0) {
			throw new Exception("Ingressos Esgotados");
		}
		else if(disponivel.equals("Interrompida")){
			throw new Exception("Sessão Interrompida");
		}else if(disponivel.equals("Cancelada")) {
			throw new Exception("Sessão Cancelada");
		}
		
		ingressosVendidos += ingresso;
		vagas -= ingresso;
	}
	
}
