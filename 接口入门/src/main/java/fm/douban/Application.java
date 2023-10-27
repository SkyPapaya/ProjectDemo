package fm.douban;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import fm.douban.service.SongService;
import fm.douban.model.Song;

/**
 * Application
 */
public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("fm.douban");
        
        SongService songService = context.getBean(SongService.class);
        //获取歌曲
        Song song = songService.get("001");
        System.out.println("得到歌曲："+song.getName()+song.getId());

    }
}
