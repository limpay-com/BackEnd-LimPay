package br.com.limpay.repository;

import br.com.limpay.domain.Coordenadas;
import org.springframework.stereotype.Repository;
import java.io.IOException;
@Repository
public interface CoordenadasRepository {
    Coordenadas obterCoordenadas(String endereco) throws IOException;
}
