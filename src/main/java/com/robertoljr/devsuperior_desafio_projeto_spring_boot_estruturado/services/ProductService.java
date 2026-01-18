package com.robertoljr.devsuperior_desafio_projeto_spring_boot_estruturado.services;

import com.robertoljr.devsuperior_desafio_projeto_spring_boot_estruturado.dto.ProductDTO;
import com.robertoljr.devsuperior_desafio_projeto_spring_boot_estruturado.entities.Product;
import com.robertoljr.devsuperior_desafio_projeto_spring_boot_estruturado.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Product entity = productRepository.findById(id).get();
		return new ProductDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		return productRepository.findAll().stream().map(ProductDTO::new).toList();
	}

	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product entity = new Product();
		entity.setName(dto.name());
		entity = productRepository.save(entity);
		return new ProductDTO(entity);
	}
}
