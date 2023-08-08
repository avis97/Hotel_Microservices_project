package com.userService.user_service.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="user_table")
public class User{
    @Id
    @Column(name="ID")
    private String userId;
    @Column(name="User_Name")
    private String userName;
    @Column(name="User_Email")
    private String userEmail;
    @Column(name="User_Phone")
    private String userPhn;
    @Column(name="User_About")
    private String userAbout;
    @Transient
    private List<Rating> ratings=new ArrayList<>();
}
