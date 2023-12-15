package br.com.limpay.service.Impl;

import br.com.limpay.domain.*;
import br.com.limpay.repository.CertificadoRepository;
import br.com.limpay.service.CertificadoService;
import br.com.limpay.service.CursoService;
import br.com.limpay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class CertificadoServiceImpl implements CertificadoService {
    @Autowired
    @Lazy
    private CertificadoRepository certificadoRepository;

    @Autowired
    @Lazy
    private UserService userService;

    @Autowired
    @Lazy
    private CursoService cursoService;

    @Override
    public Certificado gerarCertificado(Long userId, Long cursoId){
        User user = userService.getUsuarioById(userId);
        Curso curso = cursoService.getCursoById(cursoId);

        Certificado certificado = new Certificado();
        certificado.setUsario(user);
        certificado.setCurso(curso);

        return certificadoRepository.save(certificado);
    }
}
