package Sistema;

import java.util.ArrayList;

import usuarios.Administrador;
import usuarios.Usuario;
/**
 * É uma classe guarda todas as informações do projeto Cine Monteiro
 * @author William Aires
 *
 */

public class CentralDeInformacoes {
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Sala> salasDoCinema = new ArrayList<Sala>();
	private ArrayList<Filme> filmes = new ArrayList<Filme>();

	private static CentralDeInformacoes central;

////////////////////////////METODOS DOS CADASTROS////////////////////////////////
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	/**
	 * A adiciona o administrador a central de informações, caso já esteja cadastrado abre a janela de login
	 * @param usuario Usado para cadastrar um administrador.
	 * @throws Exception Lança exceção Quando o email ou senha for vazia ou admin já cadastrado.
	 */
	public void adicionarAdmin(Usuario usuario)throws Exception {
		if(usuario.getEmail().isEmpty())
			throw new Exception("Digite o E-mail");
		else if(usuario.getSenha().isEmpty()) 
			throw new Exception("Digite a Senha");
		
		//CHECANDO SE JÁ EXISTE UM CADASTRO COM ESSE E-MAIL
		for (Usuario u : usuarios) {
			if(u instanceof Administrador)
				throw new Exception("Administrador já Cadastrado");

		}
		usuarios.add(usuario);
	}
	/**
	 * Adiciona o usuario a central de informações
	 * @param usuario Usado para cadastrar um usuario comum.
	 * @throws Exception Lança exceção Quando o email ou senha for vazio e caso exista um com o mesmo email.
	 */
	public void adicionarUsuario(Usuario usuario) throws Exception {
		if(usuario.getEmail().isEmpty())
			throw new Exception("Digite o E-mail");
		else if(usuario.getSenha().isEmpty()) 
			throw new Exception("Digite a Senha");
		
		//CHECANDO SE JÁ EXISTE UM CADASTRO COM ESSE E-MAIL
		for (Usuario u : usuarios) {
			if(usuario.getEmail().equals(u.getEmail()))
				throw new Exception("Usuário já Cadastrado");
		}
		usuarios.add(usuario);
	}
	/**
	 * Recupera o usuario da central
	 * @param email Usado como checar se existe um usuario cadastrado.
	 * @param senha Usado para checar se a senha está correta.
	 * @return Um objeto do tipo usuario(Cliente/Administrador).
	 * @throws Exception Lança exceção quando o usuario não estiver cadastrado e senha incorreta.
	 */
	public Usuario recuperarUsuario(String email, String senha) throws Exception{
		Usuario u;
		if(email.isEmpty()) {
			throw new Exception("Digite um E-mail");
		}else if(senha.isEmpty()){
			throw new Exception("Digite a senha");
		}
		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(email)) {
				u = usuario;
				if(u.getSenha().equals(senha))
					return u;
				else
					throw new Exception("Senha Incorreta");
			}		
		}
		throw new Exception("Usuário não Cadastrado");		
	}
	/**
	 * Reseta a senha do usuario ou admin
	 * @param email Usado para checar se o usuario está cadastrado
	 * @param novaSenha Usado para adicionar a nova senha
	 * @throws Exception Lança exceção quando a entrada for vazia
	 */
	public void resetarSenha(String email) throws Exception {
		if(email.isEmpty()) {
			throw new Exception("Digite o E-mail");
		}
		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(email)) {
				usuario.setSenha("1234");
			}
		}
	}

////////////////////////////////METODOS DAS SESSÕES////////////////////////////////////
	/**
	 * Adiciona a sala a central
	 * @param sala Usado para adicionar a sala
	 * @throws Exception Lança exceção se já existir uma sala com o mesmo nome
	 */
	public void adicionarSala(Sala sala) throws Exception {
		for(Sala s: salasDoCinema) {
			if(sala.getNomeDaSala().equals(s.getNomeDaSala()))
				throw new Exception("Nome da sala já existe");
		}
		salasDoCinema.add(sala);
	}
	
	public ArrayList<Sala> recuperarArrayDeSalas(){
		return salasDoCinema;
	}
	public ArrayList<Sala> checarArray() throws Exception{
		if(salasDoCinema.isEmpty()) {
			throw new Exception("Salas não cadastradas");
		}
		return salasDoCinema;
	}
	
	
///////////////////////////////////////////METODOS DE FILMES////////////////////////////////////////////////
	/**
	 * Adiciona o filme a central
	 * @param filme Usado para adicionar o filme
	 */
	public void adicionarFilme(Filme filme){
		filmes.add(filme);
	}
	
	public ArrayList<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(ArrayList<Filme> filmes) {
		this.filmes = filmes;
	}
}
