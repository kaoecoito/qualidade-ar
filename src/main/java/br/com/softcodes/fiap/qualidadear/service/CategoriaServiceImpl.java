package br.com.softcodes.fiap.qualidadear.service;

import br.com.softcodes.fiap.qualidadear.model.Categoria;
import br.com.softcodes.fiap.qualidadear.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public boolean existeCategoriaDescricao(String descricao) {
        return categoriaRepository.existsByDescricao(descricao);
    }

    @Override
    public Categoria getCategoriaDescricao(String descricao) {
        return categoriaRepository.findByDescricao(descricao);
    }
}
