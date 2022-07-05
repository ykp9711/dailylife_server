package com.dailylife.domain.user.entity;

import com.dailylife.domain.user.dto.UserJoinRequest;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "tbl_user")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNum;

    private String userId;

    private String userName;

    private String userPassword;

    private String userPhoneNumber;

    private String userEmail;

    private LocalDateTime userJoinDate;

    private String userProfileImg;

    private String accessToken;

    public static User toEntity(UserJoinRequest userJoinRequest) {
        return  User.builder()
                .userId(userJoinRequest.getUserId())
                .userPassword(userJoinRequest.getUserPassword())
                .userName(userJoinRequest.getUserName())
                .userPhoneNumber(userJoinRequest.getUserPhoneNumber())
                .userEmail(userJoinRequest.getUserEmail())
                .userJoinDate(LocalDateTime.now())
                .build();
    }


}
