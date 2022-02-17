package Sistema;

import java.util.ArrayList;

import usuarios.Administrador;
import usuarios.Usuario;
/**
 * � uma classe guarda todas as informa��es do projeto Cine Monteiro
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
	 * A adiciona o administrador a central de informa��es, caso j� esteja cadastrado abre a janela de login
	 * @param usuario Usado para cadastrar um administrador.
	 * @throws Exception Lan�a exce��o Quando o email ou senha for vazia ou admin j� cadastrado.
	 */
	public void adicionarAdmin(Usuario usuario)throws Exception {
		if(usuario.getEmail().isEmpty())
			throw new Exception("Digite o E-mail");
		else if(usuario.getSenha().isEmpty()) 
			throw new Exception("Digite a Senha");
		
		//CHECANDO SE J� EXISTE UM CADASTRO COM ESSE E-MAIL
		for (Usuario u : usuarios) {
			if(u instanceof Administrador)
				throw new Exception("Administrador j� Cadastrado");

		}
		usuarios.add(usuario);
	}
	/**
	 * Adiciona o usuario a central de informa��es
	 * @param usuario Usado para cadastrar um usuario comum.
	 * @throws Exception Lan�a exce��o Quando o email ou senha for vazio e caso exista um com o mesmo email.
	 */
	public void adicionarUsuario(Usuario usuario) throws Exception {
		if(usuario.getEmail().isEmpty())
			throw new Exception("Digite o E-mail");
		else if(usuario.getSenha().isEmpty()) 
			throw new Exception("Digite a Senha");
		
		//CHECANDO SE J� EXISTE UM CADASTRO COM ESSE E-MAIL
		for (Usuario u : usuarios) {
			if(usuario.getEmail().equals(u.getEmail()))
				throw new Exception("Usu�rio j� Cadastrado");
		}
		usuarios.add(usuario);
	}
	/**
	 * Recupera o usuario da central
	 * @param email Usado como checar se existe um usuario cadastrado.
	 * @param senha Usado para checar se a senha est� correta.
	 * @return Um objeto do tipo usuario(Cliente/Administrador).
	 * @throws Exception Lan�a exce��o quando o usuario n�o estiver cadastrado e senha incorreta.
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
		throw new Exception("Usu�rio n�o Cadastrado");		
	}
	/**
	 * Reseta a senha do usuario ou admin
	 * @param email Usado para checar se o usuario est� cadastrado
	 * @param novaSenha Usado para adicionar a nova senha
	 * @throws Exception Lan�a exce��o quando a entrada for vazia
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

////////////////////////////////METODOS DAS SESS�ES////////////////////////////////////
	/**
	 * Adiciona a sala a central
	 * @param sala Usado para adicionar a sala
	 * @throws Exception Lan�a exce��o se j� existir uma sala com o mesmo nome
	 */
	public void adicionarSala(Sala sala) throws Exception {
		for(Sala s: salasDoCinema) {
			if(sala.getNomeDaSala().equals(s.getNomeDaSala()))
				throw new Exception("Nome da sala j� existe");
		}
		salasDoCinema.add(sala);
	}
	
	public ArrayList<Sala> recuperarArrayDeSalas(){
		return salasDoCinema;
	}
	public ArrayList<Sala> checarArray() throws Exception{
		if(salasDoCinema.isEmpty()) {
			throw new Exception("Salas n�o cadastradas");
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
