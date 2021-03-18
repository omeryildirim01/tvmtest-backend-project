package com.yildirimomer.tvmtest.controller;

import com.yildirimomer.tvmtest.domain.dto.UserDto;
import com.yildirimomer.tvmtest.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * Created by Omer YILDIRIM on 18.03.2021.
 */

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
@io.swagger.annotations.Api(value = "User api doc")
public class UserController {

    /**
     * service impl object
     */
    private final UserServiceImpl userService;

    /**
     * to save object
     * @param userDto
     * @return saved object
     */
    @PostMapping
    @ApiOperation(value = "Api method; to save an object",notes = "this is a demo")
    public ResponseEntity<UserDto> save( @RequestBody UserDto userDto){
        Assert.notNull(userDto.getName(), "Name mustn't be null");
        return ResponseEntity.ok(userService.save(userDto));
    }

    /**
     * to get all items
     * @return List of items
     */
    @GetMapping
    @ApiOperation(value = "Api method; to get all objects",notes = "this is a demo")
    public ResponseEntity<List<UserDto>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    /**
     * To get page items using params.
     * @param pageNo
     * @param pageSize
     * @param sortBy
     * @return
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ApiOperation(value = "Api method; to get objects of the page ",notes = "this is a demo")
    public ResponseEntity<List<UserDto>> getPage(@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy)
    {
        PageRequest pageable = PageRequest.of(pageNo - 1, pageSize);
        Page<UserDto> resultPage = userService.getAll(pageable);
        return ResponseEntity.ok(resultPage.toList());
    }

    /**
     * To find by name , name is optional parameter
     * @param name
     * @return
     */
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    @ApiOperation(value = "Api method;  to find,search objects using by name param ",notes = "this is a demo")
    public ResponseEntity<List<UserDto>> findByName(@RequestParam Optional<String> name) {
        List<UserDto> resultList = userService.findByName(name);
        return ResponseEntity.ok(resultList);
    }

    /**
     * To find by id
     * @param id
     * @return
     */
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    @ApiOperation(value = "Api method; to find a record using by id ",notes = "this is a code")
    public ResponseEntity<UserDto> findById(@RequestParam Long id) {
        UserDto result = userService.findById(id);
        if (result !=null){
            return ResponseEntity.ok(result);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
