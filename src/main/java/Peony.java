import com.peony.annotation.bean.Car;
import com.peony.annotation.configuration.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sound.midi.Soundbank;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Peony {
    public static void main(String[] args) {

        ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.systemDefault());

        System.out.println(zonedDateTime.getHour());
        System.out.println(zonedDateTime.getMinute());

        String format = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(zonedDateTime);
        System.out.println(format);
//        LocalDateTime localDateTime = LocalDateTime.from(Instant.ofEpochMilli(now));
//
//        System.out.println(localDateTime.getHour());
//        System.out.println(localDateTime.getMinute());

    }


}
