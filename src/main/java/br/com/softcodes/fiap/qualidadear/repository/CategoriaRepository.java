package br.com.softcodes.fiap.qualidadear.repository;

import br.com.softcodes.fiap.qualidadear.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    boolean existsByDescricao(String descricao);

    Categoria findByDescricao(String descricao);

}
