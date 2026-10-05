package com.apibiblioteca.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apibiblioteca.biblioteca.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

    List<Livro> findByTituloContainingIgnoreCase(String titulo);

}