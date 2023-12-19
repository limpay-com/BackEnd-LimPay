package br.com.limpay.service;

import java.util.List;
import java.util.Set;

import br.com.limpay.domain.Filtro;

public interface FiltroService {
    Filtro cadastrarOuAtualizarProfissional(Filtro filtro);

    List<Filtro> encontrarPorHabilidades(Set<String> habilidades);

    List<Filtro> filtrarPorTipoLimpeza(String tipoLimpeza);
}
