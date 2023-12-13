package br.com.limpay.webcontroller;

import br.com.limpay.domain.Register;
import br.com.limpay.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService){
        this.registerService = registerService;
    }

    @PostMapping("register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Register register){
        registerService.registerUser(register);
        return ResponseEntity.ok(gerarResposta("Usuario registrado com sucesso!"));
    }

    private Map<String, String>gerarResposta(String mensagem){
        Map<String, String> response = new HashMap<>();
        response.put("Mensagem: ", mensagem);
        return response;
    }
}
