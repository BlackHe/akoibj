import com.peony.ibatis.entity.BookDO;
import com.peony.ibatis.repository.BookDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

public class Peony {
    public static void main(String[] args) {
        // 拉姆达demo
        action(()->{
            print();
        });
        //内联demo
        action(Peony::print);
    }

    static void action(Command command){
        command.query();
    }

    static void print(){
        System.out.println("666");
    }

    interface Command{
        void query();
    }

}
