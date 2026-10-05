package com.apibiblioteca.biblioteca.entity;

import jakarta.persistence.Colunm;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Entity;

@Entity
@Table(name = "livro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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