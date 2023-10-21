package br.com.brunoyamada.AppProdutos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.brunoyamada.AppProdutos.model.Estoque;

public interface EstoqueServiceInterface {
	
	Estoque save(Estoque estoque);
	Optional<Estoque> getById(Long id);
	List<Estoque> getAll();
	Estoque update(Estoque estoque);
	void delete(Long id);
	Estoque addquantidade(Long id, int quantidade);
	Estoque delquantidade(Long id, int quantidade);

}
