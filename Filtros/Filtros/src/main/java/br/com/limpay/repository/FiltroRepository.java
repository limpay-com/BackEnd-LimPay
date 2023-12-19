package br.com.limpay.repository;

import br.com.limpay.domain.Filtro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface FiltroRepository extends JpaRepository<Filtro, Long> {
    List<Filtro> findByHabilidadesIn(Set<String> habilidades);

    List<Filtro> findByTipoLimpeza(String tipoLimpeza);
}
