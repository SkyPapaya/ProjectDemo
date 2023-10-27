package fm.douban.service.impl;

import org.springframework.stereotype.Service;
import fm.douban.service.SongService;
import fm.douban.model.Song;

import java.util.*;

@Service
public class SongServiceImpl implements SongService {
  
  private static Map<String, Song> songMap = new HashMap<>();

  static {
      Song song = new Song();
      song.setId("001");
      song.setSubjectId("s001");
      song.setLyrics("...");
      song.setName("成都");
      songMap.put(song.getId(), song);
  }

  @Override
  public Song get(String songId) {
      return songMap.get(songId);
  }
}