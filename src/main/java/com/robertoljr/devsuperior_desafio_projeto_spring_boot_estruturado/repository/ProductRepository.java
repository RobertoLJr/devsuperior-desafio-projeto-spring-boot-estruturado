package com.robertoljr.devsuperior_desafio_projeto_spring_boot_estruturado.repository;

import com.robertoljr.devsuperior_desafio_projeto_spring_boot_estruturado.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
