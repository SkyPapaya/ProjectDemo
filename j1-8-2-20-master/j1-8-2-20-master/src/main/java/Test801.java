import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test801 {

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date = "2019/03/21";
        LocalDate time = LocalDate.parse(date, dtf);
        int weeks = time.getDayOfMonth();
        System.out.println(weeks);

    }


}