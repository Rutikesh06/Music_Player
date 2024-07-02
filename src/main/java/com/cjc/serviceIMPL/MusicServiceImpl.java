package com.cjc.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.dao.MusicRepository;
import com.cjc.model.Music;
import com.cjc.service.FileStorageService;
import com.cjc.service.MusicService;

@Service
public class MusicServiceImpl implements MusicService {

	@Autowired
	private MusicRepository musicRepository;

	@Autowired
	private FileStorageService fileStorageService;

	@Override
	public Music saveMusic(Music music, MultipartFile file) throws Exception {
		String fileUrl = fileStorageService.uploadFile(file);
		music.setFileUrl(fileUrl);
		return musicRepository.save(music);
	}

	@Override
	public List<Music> getAllMusic() {
		return musicRepository.findAll();
	}

	@Override
	public Music getMusicById(Long id) {
		return musicRepository.findById(id).orElse(null);
	}

	@Override
	public Music updateMusic(Long id, Music music) {
		Music existingMusic = musicRepository.findById(id).orElse(null);
		if (existingMusic != null) {
			existingMusic.setTitle(music.getTitle());
			existingMusic.setArtist(music.getArtist());
			existingMusic.setAlbum(music.getAlbum());
			existingMusic.setYear(music.getYear());
			return musicRepository.save(existingMusic);
		}
		return null;
	}

	@Override
	public void deleteMusic(Long id) {
		musicRepository.deleteById(id);
	}
}
