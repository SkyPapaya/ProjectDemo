package fm.douban.service;

import fm.douban.model.Song;

public interface SongService {
  
  Song get(String songId);

}