package br.com.softcodes.fiap.qualidadear;

import br.com.softcodes.fiap.qualidadear.config.StartConfiguration;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class QualidadeArApplication {

    public static void main(String[] args) {
        SpringApplication.run(QualidadeArApplication.class, args);
    }

    private final StartConfiguration startConfiguration;

    @PostConstruct
    public void start() {
        startConfiguration.preparaAmbiente();
    }
}
