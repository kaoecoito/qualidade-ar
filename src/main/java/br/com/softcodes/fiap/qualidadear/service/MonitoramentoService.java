package br.com.softcodes.fiap.qualidadear.service;

import br.com.softcodes.fiap.qualidadear.model.Monitoramento;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public interface MonitoramentoService {

    record AddMonitoramento(
            @NotNull(message = "A região é obrigatória") @Positive(message = "A região deve ser válida") Integer regiao,
            @NotNull(message = "O valorMedido é obrigatório") @Positive(message = "O valor deve ser maior que zero") Double valorMedido,
            @NotEmpty(message = "A categoria é obrigatória") String categoria) {
    }

    record UpdateMonitoramento(
            @NotNull(message = "O valorMedido é obrigatório") @Positive(message = "O valor deve ser maior que zero") Double valorMedido) {
    }

    class MonitoramentoInvalidoException extends RuntimeException {
        public MonitoramentoInvalidoException(String message) {
            super(message);
        }
    }


    Monitoramento save(AddMonitoramento item);

    Monitoramento save(Integer id, UpdateMonitoramento item);

    boolean delete(Integer id);

    Monitoramento get(Integer id);
}
