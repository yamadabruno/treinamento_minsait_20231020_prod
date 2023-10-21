package br.com.brunoyamada.AppProdutos.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brunoyamada.AppProdutos.exception.ResourceNotFoundException;
import br.com.brunoyamada.AppProdutos.model.Estoque;
import br.com.brunoyamada.AppProdutos.repository.EstoqueRepository;
import br.com.brunoyamada.AppProdutos.service.interfaces.EstoqueServiceInterface;

@Service
public class EstoqueService implements EstoqueServiceInterface {
	
	private EstoqueRepository estoqueRepository;
	
	@Autowired
	public EstoqueService(EstoqueRepository estoqueRepository) {
		this.estoqueRepository = estoqueRepository;
	}

	@Override
	public Estoque save(Estoque estoque) {
		return estoqueRepository.save(estoque);
	}

	@Override
	public Optional<Estoque> getById(Long id) {
		return estoqueRepository.findById(id);
	}

	@Override
	public List<Estoque> getAll() {
		return estoqueRepository.findAll();
	}

	@Override
	public Estoque update(Estoque estoque) {
		Optional<Estoque> upEstoque = estoqueRepository.findById(estoque.getId());
		
		if(upEstoque.isPresent()) {
			Estoque newEstoque = upEstoque.get();
			newEstoque.setProduto(estoque.getProduto());
			newEstoque.setQuantidade(estoque.getQuantidade());
			return estoqueRepository.save(newEstoque);
		}
		return estoque;
	}

	@Override
	public void delete(Long id) {
		estoqueRepository.deleteById(id);
		
	}

	@Override
	public Estoque addquantidade(Long id, int quantidade) {
		return estoqueRepository.findById(id)
				.map(estoque -> {
					estoque.setQuantidade(estoque.getQuantidade() + quantidade);
					return estoqueRepository.save(estoque);
				}).orElseThrow(() -> new ResourceNotFoundException("Estoque não encontrado no ID: " + id));
	}

	@Override
	public Estoque delquantidade(Long id, int quantidade) {
		return estoqueRepository.findById(id)
				.map(estoque -> {
					estoque.setQuantidade(estoque.getQuantidade() - quantidade);
					return estoqueRepository.save(estoque);
				}).orElseThrow(() -> new ResourceNotFoundException("Estoque não encontrado no ID: " + id));
	}

}
