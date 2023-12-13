package br.com.limpay.webcontroller;

import br.com.limpay.domain.User;
import br.com.limpay.service.UserService;
import br.com.limpay.security.TokenSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final TokenSecurity tokenSecurity;
    private final UserService userService;
    private static final String AUTHORIZATION_HEADER = "Authorization";

    @Autowired
    public UserController(TokenSecurity tokenSecurity, UserService userService) {
        this.tokenSecurity = tokenSecurity;
        this.userService = userService;
    }

    @PostMapping("signup")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String token = TokenSecurity.gerarToken((UserDetails) authentication.getPrincipal());
        return ResponseEntity.ok(gerarRespostaLogin(token));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody User user) {
        // A autenticação será tratada automaticamente pelo Spring Security
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String token = TokenSecurity.gerarToken((UserDetails) authentication.getPrincipal());
        return ResponseEntity.ok(gerarRespostaLogin(token));
    }

    @GetMapping("/user")
    public ResponseEntity<Map<String, String>> getUser(HttpServletRequest request) {
        String token = extractToken(request);
        String username = TokenSecurity.getNomeUsuarioToken(token);
        User user = userService.findUserByEmail(username);
        Map<String, String> response = new HashMap<>();
        response.put("Username", user.getEmail());
        return ResponseEntity.ok(response);
    }

    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (bearerToken != null && bearerToken.startsWith("Portador ")) {
            return bearerToken.substring(8);
        }
        return null;
    }

    private Map<String, String> gerarRespostaLogin(String token) {
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return response;
    }
}
