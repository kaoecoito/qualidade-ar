package br.com.softcodes.fiap.qualidadear.config;

import br.com.softcodes.fiap.qualidadear.model.Categoria;
import br.com.softcodes.fiap.qualidadear.model.Contato;
import br.com.softcodes.fiap.qualidadear.service.CategoriaService;
import br.com.softcodes.fiap.qualidadear.service.ContatoService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@AllArgsConstructor
public class StartConfiguration {

    private final ContatoService contatoService;
    private final CategoriaService categoriaService;

    public void preparaAmbiente() {

        final var contatospreparacao = List.of(
                new Contato(null, "Teste 1", "teste1@gmail.com", "1199999991"),
                new Contato(null, "Teste 2", "teste2@gmail.com", "1199999992")
        );

        contatospreparacao.forEach(contato -> {
            if (!contatoService.existeContatoEmail(contato.getEmail())) {
                contatoService.salvar(contato);
            }
        });

        final var contato = contatoService.getContatoEmail(contatospreparacao.get(0).getEmail());
        final var categoriasPreparacao = List.of(
                new Categoria(null, "umidade", 70.0, contato),
                new Categoria(null, "temperatura", 40.0, contato)
        );

        categoriasPreparacao.forEach(categoria -> {
            if (!categoriaService.existeCategoriaDescricao(categoria.getDescricao())) {
                categoriaService.salvar(categoria);
            }
        });


    }
}
