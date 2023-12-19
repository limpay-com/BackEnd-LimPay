package br.com.limpay.webcontroller;

import br.com.limpay.domain.Filtro;
import br.com.limpay.service.FiltroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/profissionais")
public class FiltroController {
    private final FiltroService filtroService;

    public FiltroController(FiltroService filtroService){
        this.filtroService = filtroService;
    }

    @GetMapping("/habilidades")
    public ResponseEntity<List<Filtro>> encontrarPorHabilidades(@RequestParam Set<String> habilidades) {
        List<Filtro> profissionais = filtroService.encontrarPorHabilidades(habilidades);
        return ResponseEntity.ok(profissionais);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Filtro> cadastrarOuAtualizarProfissional(@RequestBody Filtro filtro) {
        Filtro cadastrado = filtroService.cadastrarOuAtualizarProfissional(filtro);
        return ResponseEntity.ok(cadastrado);
    }

    @GetMapping("/tipo-limpeza")
    public ResponseEntity<List<Filtro>> filtrarPorTipoLimpeza(@RequestParam String tipoLimpeza) {
        List<Filtro> filtros = filtroService.filtrarPorTipoLimpeza(tipoLimpeza);
        return ResponseEntity.ok(filtros);
    }
}
