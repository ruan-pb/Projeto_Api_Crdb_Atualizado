package Api_Projeto_Crdb.Excecoes;

public class UsuarioInvalido extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioInvalido(String msg) {
		super(msg);
	}
	public UsuarioInvalido() {}
}
