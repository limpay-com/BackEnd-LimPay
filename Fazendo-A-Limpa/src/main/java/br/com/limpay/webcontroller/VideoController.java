package br.com.limpay.webcontroller;

import br.com.limpay.domain.*;
import br.com.limpay.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/videos")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @PostMapping("/completo/{videoId}")
    public ResponseEntity<String> marcarTodosoComoCompleto(@PathVariable Long videoId){
        videoService.marcarVideoComoCompleto(videoId);
        return ResponseEntity.ok("Video marcado como completo!");
    }
}
