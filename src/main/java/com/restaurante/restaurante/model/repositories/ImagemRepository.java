package com.restaurante.restaurante.model.repositories;

import com.restaurante.restaurante.model.entities.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long> {
}
