package br.com.softcodes.fiap.qualidadear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "MONITORAMENTO")
@SequenceGenerator(name = "MONITORAMENTO_SEQUENCE_GENERATOR", sequenceName = "MONITORAMENTO_SEQ", allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
public class Monitoramento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MONITORAMENTO_SEQUENCE_GENERATOR")
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime ocorrencia;

    @Column(nullable = false)
    private Integer regiao;

    @Column(nullable = false, precision = 4)
    private Double valorMedido;

    @ManyToOne
    private Categoria categoria;


}
