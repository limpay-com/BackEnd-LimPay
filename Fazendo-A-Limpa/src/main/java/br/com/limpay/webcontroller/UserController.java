package br.com.limpay.webcontroller;

import br.com.limpay.domain.*;
import br.com.limpay.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUsuarioById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUsuarioById(userId));
    }
}
