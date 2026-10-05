package com.apibiblioteca.biblioteca.entity;

import jakarta.persistence.Entity;

@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLivro;

    @NotBlank
    @Colunm(length = 150)
    private String tituloLivro;

    @NotBlank
    @Colunm(length = 50)
    private String autorLivro;

    @Colunm(length = 50)
    private String editorLivro;

    @NotNull
    private Integer anoPublicacaoLivro;

    @Colunm(unique = true, length 20)
    private String isbnLivro;
}