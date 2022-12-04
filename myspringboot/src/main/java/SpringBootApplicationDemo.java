
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@ComponentScan("com.example")
//开启事物
@EnableTransactionManagement
@MapperScan(basePackages = {"common.example.mapper"})
//@EnableElasticsearchRepositories(basePackages = { "com.example.elasticsearch" })
public class SpringBootApplicationDemo {


  /**
  * @Author : gyg
  * @Date : 2019年11月22日14:05:56
  * @Annotation :
 */
public static void main(String[] args) throws Exception{
    System.setProperty("es.set.netty.runtime.available.processors","false");
    SpringApplication.run(SpringBootApplicationDemo.class,args);
    
}
}
