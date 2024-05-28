package br.com.softcodes.fiap.qualidadear.service;

import br.com.softcodes.fiap.qualidadear.model.Contato;
import br.com.softcodes.fiap.qualidadear.repository.ContatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContatoServiceImpl implements ContatoService {

    private final ContatoRepository contatoRepository;

    @Override
    public Contato salvar(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public boolean existeContatoEmail(String email) {
        return contatoRepository.existsByEmail(email);
    }

    @Override
    public Contato getContatoEmail(String email) {
        return contatoRepository.findByEmail(email);
    }
}
