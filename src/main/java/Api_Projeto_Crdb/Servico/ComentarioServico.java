package Api_Projeto_Crdb.Servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Api_Projeto_Crdb.Entidades.Comentario;
import Api_Projeto_Crdb.Entidades.Disciplina;
import Api_Projeto_Crdb.Entidades.Usuario;
import Api_Projeto_Crdb.Excecoes.ComentarioException;
import Api_Projeto_Crdb.Repositorio.ComentarioRepositorio;
import Api_Projeto_Crdb.Repositorio.DisciplinaRepositorio;

@Service
public class ComentarioServico {

	@Autowired
	private ComentarioRepositorio<Comentario, Long> comentarioBD;
	
	@Autowired
	private DisciplinaRepositorio<Comentario, Integer> disciplinaBD;

	@Autowired
	private JWTServico jwtServico;

	@Autowired
	private UsuarioServico usuarioServico;

	@Autowired
	private DisciplinaServico disciplinaServico;

	public Comentario AdicionarNovoComentario(Comentario novoComentario, String autorizacao, String disciplina) {
		java.util.Date data = new java.util.Date();// data

		java.sql.Time hora = new java.sql.Time(data.getTime()); // hora

		java.sql.Date now = new java.sql.Date(data.getTime());
		String email = jwtServico.getUsuarioId(autorizacao);// validando o token

		novoComentario.setUsuario(usuarioServico.getUsuario(email));

		novoComentario.setDisciplina(disciplinaServico.getOneNome(disciplina));
		novoComentario.setData(now);
		novoComentario.setHora(hora);
		comentarioBD.save(novoComentario);
		return this.ultimoComentarioAlternativa();

	}

	public Comentario ultimoComentarioAlternativa() {
		return comentarioBD.findById(comentarioBD.count()).get();

	}

	public List<Comentario> ComentariosDeDisciplina(int id) {

		List<Comentario> comentarios = new ArrayList<>();
		Disciplina disciplina = disciplinaServico.getOne(id);

		for (Comentario p : comentarioBD.findAll()) {

			if (disciplina.getId() == id) {
				comentarios.add(p);

			}

		}

		return comentarios;
	}

	public Comentario deletarComentario(String token, Long id) {
		Optional<String> usuarioId = jwtServico.recuperarUsuario(token);
		Usuario usuario = usuarioServico.validarUsuario(usuarioId);

		Optional<Comentario> comentario = comentarioBD.findById(id);

		if (comentario.get().getUsuario().getEmail() == usuario.getEmail()) {
			if (comentario.get().getId() == id) {
				return this.Resposta(id);
			}

		}

		throw new ComentarioException("Não pode apagar comentarios de outra pessoa");

	}
	public Comentario deletar02(String token, Long id) {
		Optional<String> usuarioId = jwtServico.recuperarUsuario(token);// recupara Usuario do Token
		Usuario usuario = usuarioServico.validarUsuario(usuarioId);
		Optional<Comentario> comentario = comentarioBD.findById(id);
		if (comentario.get().getUsuario().getEmail().equals(usuario.getEmail())) {
			comentario.get().setComentario("  ");
			comentarioBD.delete(comentario.get());
			//comentarioBD.deleteById(id);
			
		}
		return comentario.get();
	}
	
	public List<Comentario> listaDeComentarioDeDisciplina(String nome) {
		System.out.println(nome);
		List<Comentario> listaDisciplina = new ArrayList<>();
		for (Disciplina dis : disciplinaBD.findAll()) {
			System.out.println("nome da disciplina " + dis.getNome());
			if (dis.getNome().equals(nome)) {
				listaDisciplina.addAll(dis.getComentario());

			}
		}
		return listaDisciplina;
	}

	public Comentario Resposta(long id) {
		Comentario comentario = comentarioBD.getOne(id);
		comentario.setComentario("   ");
		return comentario;

	}

	
	public List<Comentario> listaTodosComentarios() {
		List<Comentario> lista = comentarioBD.findAll();
		return lista;
	}

	public List<Comentario> comentariosDePessoasNome(String nome) {
		List<Comentario> ListaComentariosPorNome = new ArrayList<>();
		for (Comentario c : this.comentarioBD.findAll()) {
			if (c.getUsuario().getEmail().equals(nome)) {
				ListaComentariosPorNome.add(c);
			}
		}
		return ListaComentariosPorNome;

	}

	public Comentario buscar(long id) {
		Optional<Comentario> comentario = comentarioBD.findById(id);
		if (comentario.isPresent()) {
			return comentario.get();

		}
		throw new ComentarioException();

	}

}
