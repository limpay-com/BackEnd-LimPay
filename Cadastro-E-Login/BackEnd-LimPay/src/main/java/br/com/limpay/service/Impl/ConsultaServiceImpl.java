package br.com.limpay.service.Impl;

import br.com.limpay.domain.Consulta;
import br.com.limpay.repository.ConsultaRepository;
import br.com.limpay.service.ConsultaService;
import br.com.limpay.security.TokenConsultaSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ConsultaServiceImpl implements ConsultaService{
    private final ConsultaRepository consultaRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final TokenConsultaSecurity tokenConsultaSecurity;

    @Autowired
    public ConsultaServiceImpl(ConsultaRepository consultaRepository, BCryptPasswordEncoder passwordEncoder, TokenConsultaSecurity tokenConsultaSecurity){
        this.consultaRepository = consultaRepository;
        this.tokenConsultaSecurity = tokenConsultaSecurity;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Consulta findUserByEmail(String email){
        return consultaRepository.findByEmail(email);
    }

    @Override
    public Consulta loginUser(String email, String senha){
        Consulta consulta = consultaRepository .findByEmail(email);
        if (consulta != null && passwordEncoder.matches(senha, consulta.getSenha())){
            return consulta;
        }

        return null;
    }

    @Override
    public boolean informacoesCompletas(Consulta consulta){
        return consulta != null &&
                consulta.getEmail() != null &&
                consulta.getSenha() != null &&
                consulta.getCpf() != null &&
                consulta.getCep() != null &&
                consulta.getBairro() != null &&
                consulta.getCidade() != null &&
                consulta.getEstado() != null &&
                consulta.getNumeroCasa() != null &&
                consulta.getNumeroCelular() != null &&
                consulta.getChavePix() != null &&
                consulta.getDataNascimento() != null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        return null;
    }

    @Override
    public boolean detalhesCompletos(Consulta consulta) {
        return false;
    }
}
