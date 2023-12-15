package br.com.limpay.webcontroller;

import br.com.limpay.domain.*;
import br.com.limpay.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/certificado")
public class CertificadoController {
    @Autowired
    private CertificadoService certificadoService;

    @PostMapping("/gerar/{userId}/{cursoId}")
    public ResponseEntity<Certificado> gerarCertificado(@PathVariable Long userId, @PathVariable Long cursoId){
        return ResponseEntity.ok(certificadoService.gerarCertificado(userId, cursoId));
    }
}
