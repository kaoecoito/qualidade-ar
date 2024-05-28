package br.com.softcodes.fiap.qualidadear.service;

import br.com.softcodes.fiap.qualidadear.model.Evento;
import br.com.softcodes.fiap.qualidadear.model.Monitoramento;

public interface EventoService {

    Evento processar(Monitoramento monitoramento);

}
