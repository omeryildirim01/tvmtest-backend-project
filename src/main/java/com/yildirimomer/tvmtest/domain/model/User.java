package com.yildirimomer.tvmtest.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Omer YILDIRIM on 18.03.2021.
 */
@Entity
@Table(name= "User")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"id"}, callSuper = false)
@ApiModel(value = "User model",description = "description about user model",parent = BaseEntity.class)
public class User extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(name = "id",value = "id",dataType = "Long")
    private Long id;
    @ApiModelProperty(name = "name",value = "name",dataType = "String")
    private String name;
    @ApiModelProperty(name = "address",value = "address",dataType = "String")
    private String address;
    @ApiModelProperty(name = "telephone",value = "telephone",dataType = "String")
    private String phone;
    @ApiModelProperty(name = "mail",value = "mail",dataType = "String")
    private String email;
}