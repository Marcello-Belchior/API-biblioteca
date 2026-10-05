package com.apibiblioteca.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apibiblioteca.biblioteca.entity.Livro;
import com.apibiblioteca.biblioteca.repository.LivroRepository;

@Service
public class LivroService {
    //injeção de dependência
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    //Método para Salvar um livro
    public Livro salvar(Livro livro){
        return livroRepository.save(livro);
    }

    //Método para deletar um livro
    public void deletarLivro(Long id){
        livroRepository.deleteById(id);
    }

    //Método para Listar os livros
    public List<Livro> buscarTodos(){
        return livroRepository.findAll();
    }

}
