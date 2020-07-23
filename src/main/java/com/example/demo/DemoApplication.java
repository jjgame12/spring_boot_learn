package com.example.demo;

import com.example.demo.callback.AbstractReCall;
import com.example.demo.callback.ReCallImpl;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author jj
 */
@ServletComponentScan // 扫描Servlet注解，否则，@WebServlet不起作用
@SpringBootApplication
//@EnableScheduling
@MapperScan("com.example.demo.mapper")
@Slf4j
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		// 测试回调
//		AbstractReCall reCall = new ReCallImpl();
//		reCall.doing();
//
//		log.info("start to sleep 5s...");
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			log.error("interrupted...");
//		}
//
//		log.info("modify global to 1...");
//		reCall.setGlobal(1);
	}
}
