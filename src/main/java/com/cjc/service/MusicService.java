package com.cjc.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cjc.model.Music;

public interface MusicService {
    Music saveMusic(Music music, MultipartFile file) throws Exception;
    List<Music> getAllMusic();
    Music getMusicById(Long id);
    Music updateMusic(Long id, Music music);
    void deleteMusic(Long id);
}
