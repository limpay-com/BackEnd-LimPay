package br.com.limpay.service.Impl;

import br.com.limpay.domain.Filtro;
import br.com.limpay.service.FiltroService;
import br.com.limpay.repository.FiltroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FiltroServiceImpl implements FiltroService{
    private final FiltroRepository filtroRepository;

    public FiltroServiceImpl(FiltroRepository filtroRepository){
        this.filtroRepository = filtroRepository;
    }

    @Override
    public List<Filtro> encontrarPorHabilidades(Set<String> habilidades) {
        return filtroRepository.findByHabilidadesIn(habilidades);
    }

    @Override
    public Filtro cadastrarOuAtualizarProfissional(Filtro filtro) {
        return filtroRepository.save(filtro);
    }

    @Override
    public List<Filtro> filtrarPorTipoLimpeza(String tipoLimpeza) {
        return filtroRepository.findByTipoLimpeza(tipoLimpeza);
    }
}
