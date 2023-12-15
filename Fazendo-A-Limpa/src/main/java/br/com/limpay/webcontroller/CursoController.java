package br.com.limpay.webcontroller;

import br.com.limpay.domain.*;
import br.com.limpay.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> pegarTodosCursos(){
        return ResponseEntity.ok(cursoService.pegarTodosCursos());
    }

    @PostMapping("/completo/{cursoId}/{userId}")
    public ResponseEntity<String> cursoCompleto(@PathVariable Long cursoId, @PathVariable Long userId){
        cursoService.completarCurso(cursoId, userId);
        return ResponseEntity.ok("Curso Completo!");
    }
}


