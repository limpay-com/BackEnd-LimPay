package br.com.limpay.service;

import br.com.limpay.domain.Consulta;
import org.springframework.security.core.userdetails.UserDetails;

public interface ConsultaService {
    Consulta findUserByEmail(String email);
    Consulta loginUser(String email, String senha);

    boolean detalhesCompletos(Consulta consulta);

    boolean informacoesCompletas(Consulta consulta);

    UserDetails loadUserByUsername(String email);
}
