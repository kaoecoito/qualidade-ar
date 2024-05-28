package br.com.softcodes.fiap.qualidadear.repository;

import br.com.softcodes.fiap.qualidadear.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

    boolean existsByEmail(String email);

    Contato findByEmail(String email);

}
