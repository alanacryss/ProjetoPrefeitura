package br.ufrn.imd.lojaRapida.negocio;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufrn.imd.lojaRapida.dao.ClienteDAO;
import br.ufrn.imd.lojaRapida.dominio.Cliente;

/**
 * Entidade da camada de negócio (business).
 * 
 * @author gleydson
 *
 */
@Stateless
public class ClienteService {
	
	@EJB
	private ClienteDAO dao;
	/**
	 * Autentica um determinado cliente e retorna true caso tenha sucesso.
	 * @param cliente
	 * @return
	 */
	public Cliente autenticar(Cliente cliente) {
		try {
			return dao.findByEmailAndSenha(cliente.getEmail(),
					cliente.getSenha());
		} finally {
			dao.close();
		}
	}	
}


