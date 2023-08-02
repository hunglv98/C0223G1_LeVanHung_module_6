package com.example.demo.service;

import com.example.demo.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongService {
    List<Song> getList();

    Song getSongById(int id);

    void addSong(Song song);

    void createSong(Song song);

    void deleteSongById(int id);

    void updateSong(Song song);

    Page<Song> getSongByName(String name, Pageable pageable);

    Page<Song> getListPagination(Pageable pageable);


}
