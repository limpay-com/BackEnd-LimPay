package br.com.limpay.service.Impl;

import br.com.limpay.domain.*;
import br.com.limpay.repository.CursoRepository;
import br.com.limpay.repository.UserRepository;
import br.com.limpay.service.CertificadoService;
import br.com.limpay.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    @Lazy
    private CursoRepository cursoRepository;

    @Autowired
    @Lazy
    private UserRepository userRepository;

    @Autowired
    @Lazy
    private CertificadoService certificadoService;

    @Override
    public List<Curso> pegarTodosCursos(){
        return cursoRepository.findAll();
    }

    @Override
    public Curso getCursoById(Long cursoId){
        return cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso não encontrado!"));
    }

    @Override
    public void completarCurso(Long cursoId, Long userId){
        Curso curso = getCursoById(cursoId);
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario não encontrado!"));

        boolean videosCompletos = curso.getVideos().stream().allMatch(Video::isCompleto);

        if (videosCompletos){
            certificadoService.gerarCertificado(userId,cursoId);
        } else{
            throw new RuntimeException("Os videos não estão completos!");
        }
    }
}
