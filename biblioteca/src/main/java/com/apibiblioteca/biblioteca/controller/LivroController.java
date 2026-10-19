
package com.apibiblioteca.biblioteca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apibiblioteca.biblioteca.entity.Livro;
import com.apibiblioteca.biblioteca.repository.LivroRepository;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping
    public List<Livro> listar(
            @RequestParam(required = false) String titulo) {

        if (titulo != null && !titulo.isBlank()) {
            return livroRepository
                    .findByTituloLivroContainingIgnoreCase(titulo);
        }

        return livroRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);

        return livro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro) {
        Livro salvo = livroRepository.save(livro);

        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(
            @PathVariable Long id,
            @RequestBody Livro dados) {

        return livroRepository.findById(id)
                .map(livro -> {
                    livro.setTituloLivro(dados.getTituloLivro());
                    livro.setAutorLivro(dados.getAutorLivro());
                    livro.setAnoPublicacaoLivro(
                            dados.getAnoPublicacaoLivro());
                    livro.setEditorLivro(dados.getEditorLivro());
                    livro.setIsbnLivro(dados.getIsbnLivro());

                    Livro atualizado = livroRepository.save(livro);
                    return ResponseEntity.ok(atualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!livroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        livroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
