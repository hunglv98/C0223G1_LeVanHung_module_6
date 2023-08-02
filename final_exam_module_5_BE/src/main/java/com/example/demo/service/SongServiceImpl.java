package com.example.demo.service;

import com.example.demo.model.Song;
import com.example.demo.repo.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SongServiceImpl implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> getList() {
        return songRepository.getAllSong();
    }

    @Override
    public Song getSongById(int id) {
        return songRepository.getSongById(id);
    }

    @Override
    public void addSong(Song song) {
        songRepository.saveSong(song);
    }

    @Override
    public void createSong(Song song) {
        songRepository.saveSong(song);
    }

    @Override
    public void deleteSongById(int id) {
        songRepository.deleteById(id);
    }

    @Override
    public void updateSong(Song song) {
        songRepository.updateSong(song);
    }

    @Override
    public Page<Song> getSongByName(String name, Pageable pageable) {
        return songRepository.getSongByName(name, pageable);
    }

    @Override
    public Page<Song> getListPagination(Pageable pageable) {
        return songRepository.getAllSongPagination(pageable);
    }
}
