package Api_Projeto_Crdb.config;
/*
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import Api_Projeto_Crdb.Entidades.Comentario;
import Api_Projeto_Crdb.Entidades.Disciplina;
import Api_Projeto_Crdb.Entidades.Usuario;
import Api_Projeto_Crdb.Repositorio.ComentarioRepositorio;
import Api_Projeto_Crdb.Repositorio.UsuarioRepositorio;


@Configuration
public class Inicializacao implements CommandLineRunner {
	
	
	@Autowired
	private UsuarioRepositorio<Usuario, String> usuarioBD;
	
	@Autowired
	private ComentarioRepositorio<Comentario, Long> comentarioBD;

	@Override
	public void run(String... args) throws Exception {
		
		java.util.Date data = new java.util.Date();//data

		java.sql.Time hora = new java.sql.Time(data.getTime()); //hora
		
		java.sql.Date now = new java.sql.Date(data.getTime());
		
		
		
		Comentario comentario = new Comentario(null, "lindo", now, hora);
		Comentario comentario01 = new Comentario(null, "maravilhoso", now, hora);
		
		comentarioBD.saveAll(Arrays.asList(comentario,comentario01));
		
		Usuario usuario = new Usuario("RuanCruz@gmail.com", "Ruan", "Cruz", "dev12345", Arrays.asList(comentario01));
		
		usuarioBD.save(usuario);
		
		
	}

}
*/