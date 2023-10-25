package ltd.cmyr.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"ltd.cmyr.demo.mapper"})
@SpringBootApplication
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("访问地址：http://127.0.0.1:8080");
		logger.info("文档地址：http://127.0.0.1:8080/swagger-ui.html");
	}

}
