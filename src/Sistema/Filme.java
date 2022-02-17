package Sistema;

public class Filme {
	private String nomeDoFilme;
	private int duracaoDoFilme;
	private String genero;
	private String classificacaoEtaria;
	private String sinopse;
	private String emCartazAte;
	
	public String getNomeDoFilme() {
		return nomeDoFilme;
	}
	public void setNomeDoFilme(String nomeDoFilme) throws Exception {
		if(nomeDoFilme.isEmpty())
			throw new Exception("Digite o nome do Filme");
		this.nomeDoFilme = nomeDoFilme;
	}
	public int getDuracaoDoFilme() {
		return duracaoDoFilme;
	}
	public void setDuracaoDoFilme(String duracaoDoFilme) throws Exception {
		if(duracaoDoFilme.isEmpty())
			throw new Exception("Digite a Duração");
		this.duracaoDoFilme = Integer.parseInt(duracaoDoFilme);
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getClassificacaoEtaria() {
		return classificacaoEtaria;
	}
	public void setClassificacaoEtaria(String classificacaoEtaria){
		this.classificacaoEtaria = classificacaoEtaria;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) throws Exception {
		if(sinopse.isEmpty())
			throw new Exception("Digite a Sinopse");
		this.sinopse = sinopse;
	}
	public String getEmCartazAte() {
		return emCartazAte;
	}
	public void setEmCartazAte(String emCartazAte) throws Exception {
		if(emCartazAte.equals("  /  /    ")) {
			throw new Exception("Digite em Cartaz Atè");
		}
		this.emCartazAte = emCartazAte;
	}
	
	public String toString() {
		return this.nomeDoFilme;
	}

}
