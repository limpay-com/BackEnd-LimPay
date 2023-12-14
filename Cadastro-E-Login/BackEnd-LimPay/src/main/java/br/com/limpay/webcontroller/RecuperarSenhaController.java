package br.com.limpay.webcontroller;

import br.com.limpay.domain.RecuperaSenha;
import br.com.limpay.service.RecuperaSenhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/resetarSenha")
public class RecuperarSenhaController {
    private final RecuperaSenhaService recuperaSenhaService;

    @Autowired
    public RecuperarSenhaController(RecuperaSenhaService recuperaSenhaService) {
        this.recuperaSenhaService = recuperaSenhaService;
    }

    @PostMapping("/esqueceuSenha")
    public ResponseEntity<Map<String, String>> esqueceuSenha(@RequestParam String email) {
        recuperaSenhaService.gerarTokenResetarSenha(email);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Token de recuperação de senha enviado com sucesso.");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/resetarSenha")
    public ResponseEntity<Map<String, String>> resetarSenha(@RequestParam String email, @RequestParam String token, @RequestParam String newPassword) {
        recuperaSenhaService.resetarSenha(email, token, newPassword);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Senha redefinida com sucesso.");
        return ResponseEntity.ok(response);
    }
}
