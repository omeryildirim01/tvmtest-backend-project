package com.yildirimomer.tvmtest.service;

import com.yildirimomer.tvmtest.domain.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    /**
     * to save an item into db
     * @param userDto
     * @return  User object
     */
    UserDto save(UserDto userDto);

    /**
     * to save  item collection
     * @param  userDtoList
     * @return
     */
    List<UserDto> saveAll(List<UserDto> userDtoList);

    /**
     * to delete an item using by item id
     * @param id
     */
    void delete(Long id);

    /**
     *  to Get all user records
     * @return Airport List
     */
    List<UserDto> getAll();

    /**
     * get All items
     * @param pageable
     * @return Page
     */
    Page<UserDto> getAll(Pageable pageable);

    /**
     *  to find records
     * @return item List
     */
    List<UserDto> findByName(Optional<String> name);

    /**
     * to find by id
     * @param id
     * @return
     */
    UserDto findById(Long id);

}