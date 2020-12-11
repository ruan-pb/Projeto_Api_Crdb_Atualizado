package Api_Projeto_Crdb.Entidades;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String comentario;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;

	@JsonFormat(pattern = "HH:mm:ss")
	private Time hora;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "comentario_usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_disciplina")
	private Disciplina disciplina;

	public Comentario() {
	}

	public Comentario(Long id, String comentario) {
		super();
		this.id = id;
		this.comentario = "comentarios";

	}
	

	public Comentario(Long id, String comentario, Date data, Time hora) {
		super();
		this.id = id;
		this.comentario = comentario;
		this.data = data;
		this.hora = hora;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	

}
