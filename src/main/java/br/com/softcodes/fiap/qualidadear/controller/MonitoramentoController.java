package br.com.softcodes.fiap.qualidadear.controller;

import br.com.softcodes.fiap.qualidadear.model.Monitoramento;
import br.com.softcodes.fiap.qualidadear.service.MonitoramentoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/monitoramento")
@AllArgsConstructor
public class MonitoramentoController {

    private final MonitoramentoService monitoramentoService;

    enum Status {
        OK,
        ERROR
    }

    public record ResponseStatus(Status status, String message) {
    }

    public record RespnseData(Status status, String message, Monitoramento monitoramento) {
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<RespnseData> create(@Valid @RequestBody MonitoramentoService.AddMonitoramento item) {
        try {
            final var monitoramento = monitoramentoService.save(item);
            return new ResponseEntity<>(new RespnseData(Status.OK, "Monitoramento salvo", monitoramento), HttpStatus.CREATED);
        } catch (MonitoramentoService.MonitoramentoInvalidoException ex) {
            return new ResponseEntity<>(new RespnseData(Status.OK, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<RespnseData> update(@PathVariable Integer id, @Valid @RequestBody MonitoramentoService.UpdateMonitoramento item) {
        try {
            final var monitoramento = monitoramentoService.save(id, item);
            return new ResponseEntity<>(new RespnseData(Status.OK, "Monitoramento atualizado", monitoramento), HttpStatus.OK);
        } catch (MonitoramentoService.MonitoramentoInvalidoException ex) {
            return new ResponseEntity<>(new RespnseData(Status.OK, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseStatus> delete(@PathVariable Integer id) {
        if (monitoramentoService.delete(id)) {
            return new ResponseEntity<>(new ResponseStatus(Status.OK, String.format("Monitoramento %s excluído", id)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseStatus(Status.ERROR, String.format("Falha ao excluir monitoramento %s", id)), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<RespnseData> get(@PathVariable Integer id) {
        final var monitoramento = monitoramentoService.get(id);
        if (monitoramento != null) {
            return new ResponseEntity<>(new RespnseData(Status.OK, String.format("Dados de %s", id), monitoramento), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new RespnseData(Status.ERROR, String.format("Monitoramento %s não existe", id), null), HttpStatus.NOT_FOUND);
        }
    }

}
