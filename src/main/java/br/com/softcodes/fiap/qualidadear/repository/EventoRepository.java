package br.com.softcodes.fiap.qualidadear.repository;

import br.com.softcodes.fiap.qualidadear.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Integer> {

}
