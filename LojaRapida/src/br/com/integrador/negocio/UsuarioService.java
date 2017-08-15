package br.com.integrador.negocio;

import br.com.integrador.dao.UsuarioDAO;
import br.com.integrador.dominio.Usuario;

public class UsuarioService {

public Usuario autenticar(Usuario usuario) {
		
		UsuarioDAO dao = new UsuarioDAO();

		try {
			return dao.buscarPorEmailESenha(usuario.getEmail(),
					usuario.getSenha());
		} finally {
			dao.close();
		}
	}	
}
