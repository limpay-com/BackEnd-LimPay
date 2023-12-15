package br.com.limpay.service.Impl;
import br.com.limpay.domain.Pagamento;
import br.com.limpay.repository.PagamentoRepository;
import br.com.limpay.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public void processarPagamento(Pagamento pagamento){
        if (pagamento == null || pagamento.getNome() == null || pagamento.getChavePix() == null){
            throw new IllegalArgumentException("Dados de pagamento não encontrada!");
        }

        Pagamento destinatario = pagamentoRepository.findByChavePix(pagamento.getChavePix());

        if (destinatario == null){
            throw new IllegalArgumentException("Usuario não encontrado!");
        }

        double valorTransferencia = pagamento.getValor();

        if (pagamento.getSaldo() >= valorTransferencia){
            pagamento.setSaldo(pagamento.getSaldo() - valorTransferencia);
            destinatario.setSaldo(destinatario.getSaldo() + valorTransferencia);

            pagamentoRepository.save(pagamento);
            pagamentoRepository.save(destinatario);

            System.out.println("Transferencia realizada com sucesso!");
        } else {
            throw new IllegalArgumentException("Saldo insuficiente!");
        }
    }
}
