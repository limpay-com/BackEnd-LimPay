package br.com.limpay.service.Impl;

import br.com.limpay.domain.RecuperaSenha;
import br.com.limpay.repository.RecuperaSenhaRepository;
import br.com.limpay.security.TokenRecuperaSenhaSecurity;

import br.com.limpay.service.RecuperaSenhaService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RecuperarSenhaServiceImpl implements RecuperaSenhaService {
    private final RecuperaSenhaRepository recuperaSenhaRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    private final TokenRecuperaSenhaSecurity tokenRecuperaSenhaSecurity;

    public RecuperarSenhaServiceImpl(RecuperaSenhaRepository recuperaSenhaRepository, BCryptPasswordEncoder passwordEncoder, TokenRecuperaSenhaSecurity tokenRecuperaSenhaSecurity) {
        this.recuperaSenhaRepository = recuperaSenhaRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenRecuperaSenhaSecurity = tokenRecuperaSenhaSecurity;
    }

    @Override
    public RecuperaSenha procurarUsuarioEmail(String email) {
        return recuperaSenhaRepository.findByEmail(email);
    }

    @Override
    public void gerarTokenResetarSenha(String email) {
        RecuperaSenha recuperaSenha = recuperaSenhaRepository.findByEmail(email);
        if (recuperaSenha != null) {
            String token = UUID.randomUUID().toString();
            recuperaSenha.setTokenRecuperacaoSenha(token);
            recuperaSenhaRepository.save(recuperaSenha);
        }
    }

    @Override
    public void resetarSenha(String email, String token, String newPassword) {
        RecuperaSenha recuperaSenha = recuperaSenhaRepository.findByEmail(email);
        if (recuperaSenha != null && recuperaSenha.getTokenRecuperacaoSenha() != null && recuperaSenha.getTokenRecuperacaoSenha().equals(token)) {
            recuperaSenha.setSenha(passwordEncoder.encode(newPassword));
            recuperaSenha.setTokenRecuperacaoSenha(null);
            recuperaSenhaRepository.save(recuperaSenha);
        }
    }
}
