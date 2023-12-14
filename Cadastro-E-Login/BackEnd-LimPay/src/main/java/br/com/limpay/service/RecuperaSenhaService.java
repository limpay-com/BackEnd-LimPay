package br.com.limpay.service;

import br.com.limpay.domain.RecuperaSenha;
public interface RecuperaSenhaService {
    RecuperaSenha procurarUsuarioEmail(String email);

    void resetarSenha(String email, String token, String novaSenha);

    void gerarTokenResetarSenha(String email);
}
