package br.com.limpay.service;
import br.com.limpay.domain.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface LoginService {
    User findUserByEmail(String email);
    User loginUser(String email, String senha);

    UserDetails loadUserByUsername(String email);
}
