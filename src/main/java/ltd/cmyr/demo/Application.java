package ltd.cmyr.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"ltd.cmyr.demo.mapper"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("访问地址：http://127.0.0.1:8080");
//		System.out.println("文档地址：http://127.0.0.1:8080/swagger-ui.html");
	}

}
