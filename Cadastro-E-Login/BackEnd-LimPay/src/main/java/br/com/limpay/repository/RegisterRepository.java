package br.com.limpay.repository;

import br.com.limpay.domain.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register, Long>{
    Register findByCpf(String cpf);
}
