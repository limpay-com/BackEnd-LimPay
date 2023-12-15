package br.com.limpay.repository.Impl;

import br.com.limpay.domain.Coordenadas;
import br.com.limpay.repository.CoordenadasRepository;
import br.com.limpay.service.Impl.CoordenadasServiceImpl;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class CoordenadasRepositoryImpl implements CoordenadasRepository {

    @Override
    public Coordenadas obterCoordenadas(String endereco) throws IOException {
        CoordenadasRepository CalculadoraDistancia = null;
        return CalculadoraDistancia.obterCoordenadas(endereco);
    }
}
