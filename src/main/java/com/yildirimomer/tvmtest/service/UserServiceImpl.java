package com.yildirimomer.tvmtest.service;

import com.yildirimomer.tvmtest.domain.dto.UserDto;
import com.yildirimomer.tvmtest.domain.model.User;
import com.yildirimomer.tvmtest.repository.UserRepository;
import com.yildirimomer.tvmtest.util.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * Created by Omer YILDIRIM on 18.03.2021.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;

    /**
     * To save item
     * @param userDto
     * @return
     */
    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        User user = ObjectMapper.map(userDto,User.class);
        user= userRepository.save(user);
        userDto.setId(user.getId());
        return userDto;
    }

    /**
     * to save  item collection
     *
     * @param userDtoList
     * @return saved object list
     */
    @Override
    public List<UserDto> saveAll(List<UserDto> userDtoList) {
        Assert.notEmpty(userDtoList,"Object list must not be empty");
        if (userDtoList !=null){
            List<User> users = ObjectMapper.mapAll(userDtoList,User.class);
            users = userRepository.saveAll(users);
            List<UserDto> savedObject = ObjectMapper.mapAll(users,UserDto.class);
            return  savedObject;
        }
        return new ArrayList<UserDto>();
    }

    /**
     * to delete specific object by using identity
     * @param id
     */
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * to get all items
     * @return List of object
     */
    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        if (users!=null && users.size()>0){
            userDtos = ObjectMapper.mapAll(users,UserDto.class);
        }
        return userDtos;
    }

    /**
     * to get all items
     * @return page of object
     */
    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        Page<User> entityPage = userRepository.findAll(pageable);
        Page<UserDto> dtoPage = entityPage.map(item-> ObjectMapper.map(item,UserDto.class));
        return dtoPage;
    }

    /**
     * to find User records
     *
     * @param name
     * @return User List
     */
    @Override
    public List<UserDto> findByName(Optional<String> name) {
        List<User> users = userRepository.findByName(name.orElse("_"));
        List<UserDto> userDtos = ObjectMapper.mapAll(users,UserDto.class);
        return userDtos;
    }

    /**
     * to find by id
     *
     * @param id
     * @return
     */
    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        UserDto userDto = null;
        if (user !=null){
            userDto = ObjectMapper.map(user,UserDto.class);
        }
        return userDto;
    }
}