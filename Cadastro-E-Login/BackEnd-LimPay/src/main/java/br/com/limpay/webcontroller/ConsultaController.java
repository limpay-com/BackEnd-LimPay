package br.com.limpay.webcontroller;

import br.com.limpay.domain.Consulta;
import br.com.limpay.security.TokenConsultaSecurity;
import br.com.limpay.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {
    private TokenConsultaSecurity tokenConsultaSecurity;
    private ConsultaService consultaService;

    @Autowired
    public ConsultaController(ConsultaService consultaService, TokenConsultaSecurity tokenConsultaSecurity){
        this.consultaService = consultaService;
        this.tokenConsultaSecurity = tokenConsultaSecurity;
    }

    @PostMapping("login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Consulta consulta) {
        Consulta autenticarConsulta = consultaService.loginUser(consulta.getEmail(), consulta.getSenha());

        if (autenticarConsulta != null) {
            UserDetails userDetails = consultaService.loadUserByUsername(autenticarConsulta.getEmail());
            String token = TokenConsultaSecurity.gerarToken(String.valueOf(userDetails));

            return ResponseEntity.ok(gerarRespostaLogin(token));
        }

        return ResponseEntity.badRequest().body(gerarRespotaError("Credenciais inválidas"));
    }

    @PostMapping("/check-details")
    public ResponseEntity<Map<String, String>> checarUsuarios(@RequestBody Consulta consulta) {
        boolean consultaDadosCompleto = consultaService.detalhesCompletos(consulta);

        if (consultaDadosCompleto) {
            return ResponseEntity.ok(gerarRespostaSucesso("Informações do usuário estão completas."));
        } else {
            return ResponseEntity.badRequest().body(gerarRespotaError("Informações do usuário estão incompletas."));
        }
    }

    private Map<String, String> gerarRespostaLogin(String token) {
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return response;
    }

    private Map<String, String> gerarRespostaSucesso(String message) {
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return response;
    }

    private Map<String, String> gerarRespotaError(String message) {
        Map<String, String> response = new HashMap<>();
        response.put("error", message);
        return response;
    }
}
