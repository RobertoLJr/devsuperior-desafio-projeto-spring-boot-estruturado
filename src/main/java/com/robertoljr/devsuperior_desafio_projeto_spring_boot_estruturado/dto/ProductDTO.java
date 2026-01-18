package com.robertoljr.devsuperior_desafio_projeto_spring_boot_estruturado.dto;

import com.robertoljr.devsuperior_desafio_projeto_spring_boot_estruturado.model.Product;

public record ProductDTO(
        Long id,
        String name
) {
    public ProductDTO(Product entity) {
        this(entity.getId(), entity.getName());
    }
}
