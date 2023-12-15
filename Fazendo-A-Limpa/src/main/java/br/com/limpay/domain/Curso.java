package br.com.limpay.domain;

import javax.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "curso")
    private List<Video> videos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public Curso() {
    }

    public Curso(String nome, List<Video> videos) {
        this.nome = nome;
        this.videos = videos;
    }
}
