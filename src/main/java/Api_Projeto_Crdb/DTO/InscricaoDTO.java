package Api_Projeto_Crdb.DTO;

import java.util.List;

import Api_Projeto_Crdb.Entidades.Usuario;

public class InscricaoDTO {
	
	private Integer idDaDisciplina;
	
	private List<Usuario> usuarioList;
	
	
	
	
	public InscricaoDTO(Integer idDaDisciplina, List<Usuario> usuarioList) {
		super();
		this.idDaDisciplina = idDaDisciplina;
		this.usuarioList = usuarioList;
	}




	public InscricaoDTO() {
		super();
	}




	public Integer getIdDaDisciplina() {
		return idDaDisciplina;
	}




	public void setIdDaDisciplina(Integer idDaDisciplina) {
		this.idDaDisciplina = idDaDisciplina;
	}




	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}




	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}
	


	
	

}
