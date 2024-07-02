package com.cjc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.model.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {
}
