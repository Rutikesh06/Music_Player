package com.cjc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.model.Music;
import com.cjc.service.MusicService;

@RestController
@RequestMapping("/api/music")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @PostMapping("/upload")
    public ResponseEntity<Music> uploadMusic(@RequestPart Music music, @RequestPart MultipartFile file) {
        try {
            Music savedMusic = musicService.saveMusic(music, file);
            return new ResponseEntity<>(savedMusic, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Music>> getAllMusic() {
        List<Music> musicList = musicService.getAllMusic();
        return new ResponseEntity<>(musicList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Music> getMusicById(@PathVariable Long id) {
        Music music = musicService.getMusicById(id);
        return new ResponseEntity<>(music, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Music> updateMusic(@PathVariable Long id, @RequestBody Music music) {
        Music updatedMusic = musicService.updateMusic(id, music);
        return new ResponseEntity<>(updatedMusic, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMusic(@PathVariable Long id) {
        musicService.deleteMusic(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
