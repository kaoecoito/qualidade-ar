package br.com.softcodes.fiap.qualidadear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "CATEGORIA")
@SequenceGenerator(name = "CATEGORIA_SEQUENCE_GENERATOR", sequenceName = "CATEGORIA_SEQ", allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORIA_SEQUENCE_GENERATOR")
    private Integer id;

    @Column(nullable = false, length = 128)
    private String descricao;

    @Column(nullable = false, precision = 4)
    private Double valorLimite;

    @ManyToOne
    private Contato contato;

}
