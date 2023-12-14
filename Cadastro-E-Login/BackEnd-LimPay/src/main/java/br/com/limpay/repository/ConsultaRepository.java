package br.com.limpay.repository;

import br.com.limpay.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Consulta findByEmail(String email);
}
