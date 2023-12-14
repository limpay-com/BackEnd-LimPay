package br.com.limpay.service.Impl;

import br.com.limpay.domain.User;
import br.com.limpay.repository.UserRepository;
import br.com.limpay.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public LoginServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public User loginUser(String email, String senha){
        User user = userRepository.findByEmail(email);

        if (user != null && passwordEncoder.matches(senha, user.getSenha())){
            return user;
        }

        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        return null;
    }
}
