package Sistema;
import java.lang.*;
import java.util.ArrayList;

public class Sala {
	private String nomeDaSala;
	private float precoDoIngresso;
	private int totalDeAssentos;
	private long id;
	private String disponivel;	
	private int sessoesAtivas;
	private float arrecadacao;
	
	private ArrayList<Sessao> sessoes = new ArrayList<Sessao>();
	
	public Sala(){
		id = System.currentTimeMillis();
	}

	public String getNomeDaSala() {
		return nomeDaSala;
	}

	public void setNomeDaSala(String nomeDaSala) throws Exception {
		if(nomeDaSala.isEmpty())
			throw new Exception("Digite o nome da Sala");
		this.nomeDaSala = nomeDaSala;
	}

	public float getPrecoDoIngresso() {
		return precoDoIngresso;
	}

	public void setPrecoDoIngresso(String precoDoIngresso) throws Exception {
		if(precoDoIngresso.equals("  .  "))
			throw new Exception("Digite o preço do ingresso");
		this.precoDoIngresso = Float.parseFloat(precoDoIngresso);
	}

	public int getTotalDeAssentos() {
		return totalDeAssentos;
	}

	public void setTotalDeAssentos(String totalDeAssentos) throws Exception {
		if(totalDeAssentos.isEmpty())
			throw new Exception("Digite o total de assentos");
		this.totalDeAssentos = Integer.parseInt(totalDeAssentos);
	}

	public String toString() {
		return nomeDaSala;
	}

	public ArrayList<Sessao> getSessoes() {
		return sessoes;
	}

	public void setSessoes(ArrayList<Sessao> sessoes) {
		this.sessoes = sessoes;
	}
	public void adicionarSessao(Sessao sessao) {
		sessoes.add(sessao);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}
	
	public int getSessoesAtivas() {
		return sessoesAtivas;
	}

	public void setSessoesAtivas(int sessoesAtivas) {
		this.sessoesAtivas += sessoesAtivas;
	}
	
	public void sessoesAtivas(int i) {
		sessoesAtivas -= i;
	}
	

	public float getArrecadacao() {
		return arrecadacao;
	}

	public void setArrecadacao(float arrecadacao) {
		this.arrecadacao += arrecadacao;
	}

	public void checarDisponibilidadeDaSala() throws Exception {
		if(disponivel.equals("Deletada"))
			throw new Exception("Sala deletada escolha outra!");		
	}
	public void checarComboBox(Sala sala) throws Exception {
		if(sala == null) {
			throw new Exception("Sala não Cadastrada");
		}
	}

}
