package com.yildirimomer.tvmtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * Created by Omer YILDIRIM on 18.03.2021.
 */

@EnableJpaRepositories
@SpringBootApplication
public class TvmtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TvmtestApplication.class, args);
    }

}
