package Api_Projeto_Crdb.Entidades;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	private String email;
	private String nome;
	private String sobrenome;
	private String senha;

	@OneToMany(mappedBy = "usuario")
	private List<Comentario> comentario;
	
	@ManyToMany(mappedBy = "usuario")
	private List<Disciplina> disciplina;

	public Usuario() {
	}
	

	public Usuario(String email, String nome, String sobrenome, String senha, List<Comentario> comentario) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.senha = senha;
		this.comentario = comentario;
	}
	public Usuario(String email, String nome, String sobrenome) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isValid() {
		return !email.isBlank() && !nome.isBlank() && !senha.isBlank();
	}

	public List<Comentario> getComentario() {
		return comentario;
	}

	public void adicionarComentario(Comentario comentario) {
		this.comentario.add(comentario);
	}

	public String toString() {
		return this.nome;
	}

}
