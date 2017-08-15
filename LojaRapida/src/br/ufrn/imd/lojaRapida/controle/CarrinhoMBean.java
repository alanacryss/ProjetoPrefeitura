package br.ufrn.imd.lojaRapida.controle;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.DragDropEvent;

import br.ufrn.imd.lojaRapida.dominio.Categoria;
import br.ufrn.imd.lojaRapida.dominio.Cliente;
import br.ufrn.imd.lojaRapida.dominio.Produto;
import br.ufrn.imd.lojaRapida.dominio.Venda;
import br.ufrn.imd.lojaRapida.negocio.ClienteService;
import br.ufrn.imd.lojaRapida.negocio.VendaService;

@ManagedBean
@SessionScoped
public class CarrinhoMBean {

	private List<Produto> itens = new ArrayList<Produto>();
	private Double valorTotal = 0.0;
	private Cliente cliente = new Cliente();
	private Categoria categoria = new Categoria();

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public String getValorTotalFormatado() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String moneyString = formatter.format(valorTotal);
		return moneyString;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setItens(List<Produto> itens) {
		this.itens = itens;
	}
	
	/**
	 * Método de controle. Observe a dependência do objeto de visualização.
	 * @param ddEvent
	 * @return
	 */
	public String adicionar(DragDropEvent ddEvent) {
		Produto produto = ((Produto) ddEvent.getData());
		itens.add(produto);
		calcularTotal();
		MensagensUtil.addInfo("Produto Adicionado");

		return null;
	}

	public String sair() {

		itens = new ArrayList<Produto>();
		valorTotal = 0.0;
		cliente = new Cliente();
		categoria = new Categoria();

		MensagensUtil.addInfo("Carrinho encerrado");

		return null;
	}
	
	/**
	 * Método de chamda do Model.
	 * @return
	 */
	public String autenticarCliente() {

		Cliente clienteAutenticado = new ClienteService().autenticar(cliente);
		
		if (clienteAutenticado != null ) {
			this.cliente = clienteAutenticado;
			MensagensUtil.addInfo("Autenticado");
		} else {	
			this.cliente = new Cliente();
			MensagensUtil.addError("Erro de Autenticação");
		}
		
		return null;
	}

	public String venda() throws Exception {

		// validações básicas podem ser feitas no controlador para evitar chamada inconsistente ao modelo.
		
		if (cliente.getCpf() == null) {
			MensagensUtil.addInfo("Cliente nãoo informado!");
			return null;
		}

		if (itens.size() == 0) {
			MensagensUtil.addInfo("Carrinho Vazio!");
			return null;
		}

		// Chama a camada de negócio (Model) para realização do processo de venda.
		
		Venda venda = new VendaService().fecharCarrinho(cliente, itens, valorTotal);
		
		MensagensUtil.addInfo("Compra " + venda.getId() + " Efetuada! Mais detalhes em Minhas compras.");

		// manipula objetos para apresentação na view.
		itens = new ArrayList<Produto>();
		valorTotal = 0.0;
		categoria = new Categoria();
		
		return null;
	}

	public String remover(Produto produto) {
		itens.remove(produto);
		calcularTotal();
		MensagensUtil.addInfo("Produto Removido");
		return null;
	}

	private void calcularTotal() {
		valorTotal = 0.0;

		for (Produto produto : itens) {
			valorTotal = Double.sum(valorTotal, produto.getPreco());

		}

	}

	public List<Produto> getItens() {
		return itens;
	}
	
	public String resumo_compra(){
		
		return "/resumo_compra";
	}	
}