package br.com.softcodes.fiap.qualidadear.service;

import br.com.softcodes.fiap.qualidadear.model.Contato;

public interface ContatoService {

    Contato salvar(Contato contato);

    Contato getContatoEmail(String email);

    boolean existeContatoEmail(String email);

}
