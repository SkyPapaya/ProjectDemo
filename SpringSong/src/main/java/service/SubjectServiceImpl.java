package service;

import model.Song;
import model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author whm89
 */
@Service
public class SubjectServiceImpl implements SbujectSrevice {
private static Map<String,Subject> map = new HashMap<>();
    @Autowired
    private SongService songService;
    static{
        Subject subject = new Subject();
        subject.setSubjectId("s1");
        map.put(subject.getSubjectId(), subject);


    }

    @Override
    public Subject list(String subjectId) {

        Subject subject = map.get(subjectId);
        List<Song> songs = songService.list(subjectId);
        subject.setSongs(songs);
        return subject;

    }
}
