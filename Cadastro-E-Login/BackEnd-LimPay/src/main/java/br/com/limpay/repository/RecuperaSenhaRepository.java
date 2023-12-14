package br.com.limpay.repository;

import br.com.limpay.domain.RecuperaSenha;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RecuperaSenhaRepository extends JpaRepository<RecuperaSenha, Long>{
    RecuperaSenha findByEmail(String email);
}
