package doit.blog.controller.user.domain;

import doit.blog.controller.user.dto.UserSignUpRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userLoginId;

    @NotNull
    private String userPassword;

    @NotNull
    private String userName;

    @NotNull
    private String userNickname;

    private String userPhoneNumber;

    @Builder
    private User(String userLoginId, String userPassword, String userName, String userNickname, String userPhoneNumber) {
        this.userLoginId = userLoginId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userNickname = userNickname;
        this.userPhoneNumber = userPhoneNumber;
    }

    public static User create(UserSignUpRequest request,PasswordEncoder passwordEncoder) {
        return User.builder().userLoginId(request.userLoginId())
                .userPassword(passwordEncoder.encode(request.userPassword()))
                .userName(request.userPassword())
                .userNickname(request.userNickname())
                .userPhoneNumber(request.userPhoneNumber())
                .build();
    }

}
