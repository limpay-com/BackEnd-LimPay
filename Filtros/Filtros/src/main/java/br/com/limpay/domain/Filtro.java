package br.com.limpay.domain;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Filtro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ElementCollection
    private List<String> habilidades;

    private String tipoLimpeza;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public String getTipoLimpeza() {
        return tipoLimpeza;
    }

    public void setTipoLimpeza(String tipoLimpeza) {
        this.tipoLimpeza = tipoLimpeza;
    }

    public Filtro() {
    }

    public Filtro(String nome, List<String> habilidades, String tipoLimpeza) {
        this.nome = nome;
        this.habilidades = habilidades;
        this.tipoLimpeza = tipoLimpeza;
    }
}
