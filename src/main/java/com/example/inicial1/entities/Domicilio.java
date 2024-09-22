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
public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private int numero;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @Builder.Default
    private List<Localidad> localidades = new ArrayList<>();
}
