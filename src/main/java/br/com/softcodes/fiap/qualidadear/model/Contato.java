package br.com.softcodes.fiap.qualidadear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "CONTATO")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "CONTATO_SEQUENCE_GENERATOR", sequenceName = "CONTATO_SEQ", allocationSize = 1)
public class Contato {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTATO_SEQUENCE_GENERATOR")
    private Integer id;

    @Column(nullable = false, length = 128)
    private String nome;

    @Column(nullable = false, length = 128, unique = true)
    private String email;

    @Column(nullable = false, length = 11)
    private String telefone;

}
