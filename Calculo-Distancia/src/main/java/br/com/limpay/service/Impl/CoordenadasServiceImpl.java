package br.com.limpay.service.Impl;

import br.com.limpay.domain.Coordenadas;
import br.com.limpay.repository.CoordenadasRepository;
import br.com.limpay.service.CoordenadasService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CoordenadasServiceImpl implements CoordenadasService {

    private final CoordenadasRepository coordenadasRepository;

    public CoordenadasServiceImpl(CoordenadasRepository coordenadasRepository) {
        this.coordenadasRepository = coordenadasRepository;
    }

    @Override
    public Coordenadas obterCoordenadas(String endereco) throws IOException {
        return coordenadasRepository.obterCoordenadas(endereco);
    }

    @Override
    public double calcularDistancia(Coordenadas coordenadas1, Coordenadas coordenadas2) {
        final int RAIO_TERRA = 6371; // Raio médio da Terra em quilômetros

        double lat1 = Math.toRadians(coordenadas1.getLatitude());
        double lon1 = Math.toRadians(coordenadas1.getLongitude());
        double lat2 = Math.toRadians(coordenadas2.getLatitude());
        double lon2 = Math.toRadians(coordenadas2.getLongitude());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dLon / 2), 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return RAIO_TERRA * c;
    }
}
