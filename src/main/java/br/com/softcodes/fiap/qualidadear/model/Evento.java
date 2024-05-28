package br.com.softcodes.fiap.qualidadear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "EVENTO")
@SequenceGenerator(name = "EVENTO_SEQUENCE_GENERATOR", sequenceName = "EVENTO_SEQ", allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENTO_SEQUENCE_GENERATOR")
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime ocorrencia;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Criticidade criticidade;

    @Column(nullable = false, length = 128)
    private String descricao;

    @ManyToOne
    private Categoria categoria;

    @Column(nullable = false)
    private Integer regiao;

}
