package br.com.limpay.repository;

import br.com.limpay.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
    Pagamento findByChavePix(String chavePix);
}
