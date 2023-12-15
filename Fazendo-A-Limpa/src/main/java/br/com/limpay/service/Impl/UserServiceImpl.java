package br.com.limpay.service.Impl;

import br.com.limpay.domain.*;
import br.com.limpay.repository.UserRepository;
import br.com.limpay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUsuarioById(Long userId){
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario não encontrado!"));
    }
}
