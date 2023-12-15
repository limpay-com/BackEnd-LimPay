package br.com.limpay.service;

import br.com.limpay.domain.*;
import java.util.List;

public interface CursoService {
    List<Curso> pegarTodosCursos();
    Curso getCursoById(Long cursoId);
    void completarCurso(Long cursoId, Long userId);
}
