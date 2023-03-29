package com.generation.vinylstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.vinylstore.model.*;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long>{
    public List<Categorias> findAllByCategoriasContainingIgnoreCase(@Param("categorias") String categorias);
}
