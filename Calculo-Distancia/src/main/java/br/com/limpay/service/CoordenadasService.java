package br.com.limpay.service;

import br.com.limpay.domain.Coordenadas;

import java.io.IOException;

public interface CoordenadasService {
    Coordenadas obterCoordenadas(String endereco) throws IOException;

    double calcularDistancia(Coordenadas coordenadas1, Coordenadas coordenadas2);
}
