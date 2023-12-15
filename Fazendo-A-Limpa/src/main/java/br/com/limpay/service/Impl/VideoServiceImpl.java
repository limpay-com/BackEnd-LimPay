package br.com.limpay.service.Impl;

import br.com.limpay.domain.*;
import br.com.limpay.repository.VideoRepository;
import br.com.limpay.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoRepository videoRepository;

    @Override
    public void marcarVideoComoCompleto(Long videoId){
        Video video = videoRepository.findById(videoId).orElseThrow();
        video.setCompleto(true);
        videoRepository.save(video);
    }
}
