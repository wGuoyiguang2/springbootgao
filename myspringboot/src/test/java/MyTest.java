import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


// SpringJUnit支持，由此引入Spring-Test框架支持！
@RunWith(SpringRunner.class)
@SpringBootTest()
public class MyTest {

    @Test
    public void test1(){
        System.out.println("haha");
    }
}
