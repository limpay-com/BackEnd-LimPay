package br.com.limpay.service;

import br.com.limpay.domain.User;

public interface UserService {
    User registerUser(User user);

    User findUserByEmail(String username);
}