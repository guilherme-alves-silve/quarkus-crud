package br.com.guilhermealvessilve.resource;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.NotFoundException;

import br.com.guilhermealvessilve.dto.CadastraProdutoDTO;
import br.com.guilhermealvessilve.entity.Produto;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

	@GET
	public List<Produto> buscarTodosProdutos() {
		return Produto.listAll();
	}
	
	@POST
	@Transactional
	public void salva(CadastraProdutoDTO dto) {
		
		Produto produto = new Produto(dto.getNome(), 
				dto.getValor());
		produto.persist();
	}
	
	@PUT
	@Path("{id}")
	@Transactional
	public void atualiza(@PathParam("id") Long id, CadastraProdutoDTO dto) {
		
		Produto.<Produto>findByIdOptional(id)
		.ifPresentOrElse(produto -> {
			produto.setNome(dto.getNome());
			produto.setValor(dto.getValor());
			produto.persist();
		}, () -> { 
			throw new NotFoundException(); 
		});
	}
	
	@DELETE
	@Path("{id}")
	@Transactional
	public void deleta(@PathParam("id") Long id) {
		Produto.<Produto>findByIdOptional(id)
		.ifPresentOrElse(Produto::delete, () -> { 
			throw new NotFoundException(); 
		});
	}
}
