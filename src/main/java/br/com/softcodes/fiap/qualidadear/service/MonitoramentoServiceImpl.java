package br.com.softcodes.fiap.qualidadear.service;

import br.com.softcodes.fiap.qualidadear.model.Monitoramento;
import br.com.softcodes.fiap.qualidadear.repository.MonitoramentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MonitoramentoServiceImpl implements MonitoramentoService {

    private final MonitoramentoRepository monitoramentoRepository;
    private final CategoriaService categoriaService;
    private final EventoService eventoService;

    private final List<Integer> REGIOES_VALIDAS = List.of(1, 2, 5, 7);

    @Override
    public Monitoramento save(AddMonitoramento item) {
        final var categoria = categoriaService.getCategoriaDescricao(item.categoria());
        if (categoria == null)
            throw new MonitoramentoInvalidoException(String.format("A categoria %s não existe", item.categoria()));
        if (!REGIOES_VALIDAS.contains(item.regiao()))
            throw new MonitoramentoInvalidoException(String.format("A região %s não é válida", item.regiao()));

        final var monitoramento = monitoramentoRepository.save(new Monitoramento(null, LocalDateTime.now(), item.regiao(), item.valorMedido(), categoria));
        eventoService.processar(monitoramento);

        return monitoramento;
    }

    @Override
    public Monitoramento save(Integer id, UpdateMonitoramento item) {
        final var monitoramento = monitoramentoRepository.findById(id).orElse(null);
        if (monitoramento == null)
            throw new MonitoramentoInvalidoException(String.format("Não existe registro para o monitoramento %s", id));
        monitoramento.setValorMedido(item.valorMedido());
        final var monitoramentoAtualizado = monitoramentoRepository.save(monitoramento);
        eventoService.processar(monitoramentoAtualizado);
        return monitoramentoAtualizado;
    }

    @Override
    public boolean delete(Integer id) {
        final var monitoramento = monitoramentoRepository.findById(id).orElse(null);
        if (monitoramento == null) return false;
        monitoramentoRepository.delete(monitoramento);
        return true;
    }

    @Override
    public Monitoramento get(Integer id) {
        return monitoramentoRepository.findById(id).orElse(null);
    }
}
