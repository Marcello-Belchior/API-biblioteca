package com.apibiblioteca.biblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "livro")


public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLivro;

    @NotBlank
    @Column(length = 150)
    private String tituloLivro;

    @NotBlank
    @Column(length = 50)
    private String autorLivro;

    @Column(length = 50)
    private String editorLivro;

    @NotNull
    private Integer anoPublicacaoLivro;

    @Column(unique = true, length =  20)
    private String isbnLivro;
}