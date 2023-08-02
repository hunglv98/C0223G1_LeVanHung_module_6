package com.example.demo.repo;

import com.example.demo.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

import java.util.List;

@Transactional
public interface ISongRepository extends JpaRepository<Song, Integer> {
    @Query(value = "select * from Song", nativeQuery = true)
    List<Song> getAllSong();

    @Query(value = "select * from Song where id= :id", nativeQuery = true)
    Song getSongById(@Param("id") int id);

    @Query(value = "select * from Song where name like concat ('%',:name,'%')", nativeQuery = true)
    Page<Song> getSongByName(@Param("name") String name, Pageable pageable);

    @Modifying
    @Query(value = "insert into Song(`name`,singer,author,duration,number_like,status_id)" +
            " value(:#{#song.name},:#{#song.singer},:#{#song.author},:#{#song.duration},:#{#song.numberLike},:#{#song.status.id}) ", nativeQuery = true)
    void saveSong(@Param("song") Song song);

    @Modifying
    @Query(value = "delete from Song where id=:id", nativeQuery = true)
    void deleteById(@Param("id") int id);

    @Modifying
    @Query(value = "update Song set `name`=:#{#song.name}, singer=:#{#song.singer}, author=:#{#song.author}, duration=:#{#song.duration}, number_like=:#{#song.numberLike}, status_id=:#{#song.status.id} " +
            "where id = :#{#song.id} ", nativeQuery = true)
    void updateSong(@Param("song") Song song);

    @Query(value = "select * from Song", nativeQuery = true)
    Page<Song> getAllSongPagination(Pageable pageable);
}
