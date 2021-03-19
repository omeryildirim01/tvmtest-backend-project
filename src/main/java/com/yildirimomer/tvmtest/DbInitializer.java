package com.yildirimomer.tvmtest;

import com.yildirimomer.tvmtest.domain.dto.UserDto;
import com.yildirimomer.tvmtest.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.*;
/**
 * Created by Omer YILDIRIM on 18.03.2021.
 */
@Component
public class DbInitializer implements CommandLineRunner {

    private UserServiceImpl userService;
    /**
     *  Demo data first init test
     */
    @Autowired
    public DbInitializer(UserServiceImpl userService) {
        this.userService = userService;

    }

    @Override
    public void run(String... args) throws Exception {
        prepareDummyDataForUsers();
    }


    /**
     * Prepare Demo data first init test
     */
    public void prepareDummyDataForUsers(){
        try {
            List<UserDto> userDtos = new ArrayList<UserDto>();
            UserDto dto1 = new UserDto();
            dto1.setId(0L);
            dto1.setAddress("Omer Yildirim");
            dto1.setEmail("mail@gmail.com");
            dto1.setName("Omer Yildirim");
            dto1.setPhone("+9002169999999");

            UserDto dto2 = new UserDto();
            dto2.setId(0L);
            dto2.setAddress("user address");
            dto2.setEmail("mail@gmail.com");
            dto2.setName("Muhammed Kanlidere");
            dto2.setPhone("+9002169999999");

            userDtos.add(dto1);
            userDtos.add(dto2);
            userService.saveAll(userDtos);
        }catch (Throwable e){
            e.printStackTrace();
        }
    }


}

