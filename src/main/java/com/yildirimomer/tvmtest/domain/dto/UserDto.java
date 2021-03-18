package com.yildirimomer.tvmtest.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Omer YILDIRIM on 18.03.2021.
 */
@Data
@EqualsAndHashCode(of={"id"},callSuper = false)
@ApiModel(value = "UserDto model",description = "description about User model",parent = BaseDto.class)
public class UserDto extends BaseDto{
    @ApiModelProperty(name = "id",value = "id",dataType = "Long")
    private Long id;
    @ApiModelProperty(name = "name",value = "name",dataType = "String")
    private String name;
    @ApiModelProperty(name = "address",value = "address",dataType = "String")
    private String address;
    @ApiModelProperty(name = "telephone",value = "telephone",dataType = "String")
    private String telephone;
    @ApiModelProperty(name = "mail",value = "mail",dataType = "String")
    private String mail;
}