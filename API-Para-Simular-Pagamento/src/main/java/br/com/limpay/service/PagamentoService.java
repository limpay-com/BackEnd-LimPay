package br.com.limpay.service;

import br.com.limpay.domain.Pagamento;
public interface PagamentoService {
    void processarPagamento(Pagamento pagamento);
}
