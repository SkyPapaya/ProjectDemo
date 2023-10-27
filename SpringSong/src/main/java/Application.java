import model.Song;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.SongServiceImpl;
import service.SongService;

public class Application {
    /*
    在主函数中，调用接口中的方法，这时候再通过接口去调用实现类中的具体方法

     */

    public static void main(String[] args) {
        //coL容器的启动
        ApplicationContext context = new AnnotationConfigApplicationContext(SongServiceImpl.class);
        //实例化接口
        SongService songService = context.getBean(SongService.class);
        //调用接口中的方法来实例化
        Song song = songService.get("1");

        System.out.println(song.getName());

    }
}
