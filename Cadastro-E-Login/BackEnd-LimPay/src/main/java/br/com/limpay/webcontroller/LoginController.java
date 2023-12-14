package br.com.limpay.webcontroller;

import br.com.limpay.domain.User;
import br.com.limpay.security.TokenSecurity;
import br.com.limpay.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    private final TokenSecurity tokenSecurity;
    private final LoginService loginService;

    @Autowired
    public LoginController(TokenSecurity tokenSecurity, LoginService loginService){
        this.loginService = loginService;
        this.tokenSecurity = tokenSecurity;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody User user){
        User autenticarUsuario = loginService.loginUser(user.getEmail(), user.getSenha());

        if (autenticarUsuario != null){
            UserDetails userDetails = loginService.loadUserByUsername(autenticarUsuario.getEmail());
            String token = TokenSecurity.gerarToken(userDetails);

            return ResponseEntity.ok(gerarRespostaLogin(token));
        }

        return ResponseEntity.badRequest().body(gerarRespostaError("Email e Senha invalidas!"));
    }

    @GetMapping("/user")
    public ResponseEntity<Map<String, String>> getUser(HttpServletRequest request){
        String token = extractToken(request);
        String username = TokenSecurity.getNomeUsuarioToken(token);
        User user = loginService.findUserByEmail(username);
        Map<String, String> response = new HashMap<>();
        response.put("Usuario: ", user.getEmail());
        return ResponseEntity.ok(response);
    }

    private String extractToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Autorizado");
        if (bearerToken != null && bearerToken.startsWith("Portador: ")){
            return bearerToken.substring(8);
        }
        return null;
    }

    private Map<String, String> gerarRespostaLogin(String token){
        Map<String, String> response = new HashMap<>();
        response.put("Token: ", token);
        return response;
    }

    private Map<String, String> gerarRespostaError(String mensagem){
        Map<String, String> response = new HashMap<>();
        response.put("Erro: ", mensagem);
        return response;
    }
}
