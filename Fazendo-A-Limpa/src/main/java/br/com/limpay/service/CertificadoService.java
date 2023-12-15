package br.com.limpay.service;

import br.com.limpay.domain.*;

public interface CertificadoService {
    Certificado gerarCertificado(Long userId, Long cursoId);
}
