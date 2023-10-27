package service;

import model.Song;

import java.util.List;

public interface SongService {
    Song get(String id);
    List<Song> list(String subjectId);


}
