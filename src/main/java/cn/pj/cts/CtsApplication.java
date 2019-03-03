package cn.pj.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = {"cn.pj.cts.aop"})
public class CtsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CtsApplication.class, args);
    }

}

