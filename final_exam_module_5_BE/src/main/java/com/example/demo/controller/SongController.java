package com.example.demo.controller;

import com.example.demo.model.Song;
import com.example.demo.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/")
    public ResponseEntity<?> getList() {
        return new ResponseEntity<>(songService.getList(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSongById(@PathVariable int id) {
        return new ResponseEntity<>(songService.getSongById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/")
    public ResponseEntity<?> createSong(@RequestBody Song song) {
        songService.createSong(song);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSong(@PathVariable int id, @RequestBody Song song) {
//        Song song = songService.getSongById(id);
        songService.updateSong(song);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        songService.deleteSongById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/search/{name}/pages/{page}/{limit}")
    public ResponseEntity<?> getSongByName(@PathVariable String name, @PathVariable int page, @PathVariable int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return new ResponseEntity<>(songService.getSongByName(name, pageable), HttpStatus.ACCEPTED);
    }

    @GetMapping("/pages/{page}/{limit}")
    public ResponseEntity<?> getSongPagination(@PathVariable int page, @PathVariable int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        if (songService.getListPagination(pageable).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(songService.getListPagination(pageable), HttpStatus.ACCEPTED);
    }
}
