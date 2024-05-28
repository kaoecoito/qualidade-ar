package br.com.softcodes.fiap.qualidadear.service;

import br.com.softcodes.fiap.qualidadear.model.Categoria;

public interface CategoriaService {

    Categoria salvar(Categoria categoria);

    boolean existeCategoriaDescricao(String descricao);

    Categoria getCategoriaDescricao(String descricao);

}
