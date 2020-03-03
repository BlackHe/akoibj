import com.peony.annotation.bean.Car;
import com.peony.annotation.configuration.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Peony {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Car car = context.getBean(Car.class);


        // 拉姆达demo
        action(() -> {
            print();
        });
        //内联demo
        action(Peony::print);
    }

    static void action(Command command) {
        command.query();
    }

    static void print() {
        System.out.println("666");
    }

    interface Command {
        void query();
    }

}
