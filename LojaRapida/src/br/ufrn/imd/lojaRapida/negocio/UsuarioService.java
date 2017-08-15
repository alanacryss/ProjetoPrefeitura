package br.ufrn.imd.lojaRapida.negocio;

import br.ufrn.imd.lojaRapida.dao.UsuarioDAO;
import br.ufrn.imd.lojaRapida.dominio.Usuario;

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
