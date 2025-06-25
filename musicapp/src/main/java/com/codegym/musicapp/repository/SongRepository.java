package com.codegym.musicapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<com.codegym.model.Song, Long> {
}