package br.com.limpay.webcontroller;

import br.com.limpay.domain.Coordenadas;
import br.com.limpay.service.CoordenadasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CoordenadasController {

    private final CoordenadasService coordenadasService;

    public CoordenadasController(CoordenadasService coordenadasService) {
        this.coordenadasService = coordenadasService;
    }

    @GetMapping("/calcularDistancia")
    public String calcularDistancia(
            @RequestParam String endereco1,
            @RequestParam String endereco2
    ) {
        try {
            Coordenadas coordenadas1 = coordenadasService.obterCoordenadas(endereco1);
            Coordenadas coordenadas2 = coordenadasService.obterCoordenadas(endereco2);

            double distancia = coordenadasService.calcularDistancia(coordenadas1, coordenadas2);

            return "A distância entre os endereços é: " + distancia + " km";
        } catch (IOException e) {
            return "Erro ao obter coordenadas: " + e.getMessage();
        }
    }
}
