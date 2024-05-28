package br.com.softcodes.fiap.qualidadear.service;

import br.com.softcodes.fiap.qualidadear.model.Criticidade;
import br.com.softcodes.fiap.qualidadear.model.Evento;
import br.com.softcodes.fiap.qualidadear.model.Monitoramento;
import br.com.softcodes.fiap.qualidadear.repository.EventoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventoServiceImpl implements EventoService {

    private final EventoRepository eventoRepository;

    @Override
    public Evento processar(Monitoramento monitoramento) {
        final var taxa = monitoramento.getValorMedido() / monitoramento.getCategoria().getValorLimite();

        final Criticidade criticidade;
        if (taxa >= 0.85) {
            criticidade = Criticidade.ALTA;
        } else if (taxa >= 0.5) {
            criticidade = Criticidade.MEDIA;
        } else {
            criticidade = Criticidade.BAIXA;
        }

        return eventoRepository.save(new Evento(
                null,
                monitoramento.getOcorrencia(),
                criticidade,
                String.format("Monitoramento de criticidad %s registrada para valor %s", criticidade, monitoramento.getValorMedido()),
                monitoramento.getCategoria(),
                monitoramento.getRegiao()
        ));
    }
}
