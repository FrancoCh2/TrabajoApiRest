package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private int fecha;
    private String genero;

    private int paginas;
    private String autor;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "Libro_Autor",
            joinColumns = @JoinColumn(name="libro_id"),
            inverseJoinColumns = @JoinColumn(name="autor_id")

    )
    @Builder.Default
    private List<Autor> libros = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_persona")
    @Builder.Default
    private Persona persona = new Persona();
}