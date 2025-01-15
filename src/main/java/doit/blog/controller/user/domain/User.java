package doit.blog.controller.user.domain;

import doit.blog.controller.user.dto.UserInfoUpdateRequest;

import doit.blog.controller.user.dto.UserSignUpRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {

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

    public static User create(UserSignUpRequest request, PasswordEncoder passwordEncoder){
        return User.builder().userLoginId(request.userLoginId())
                .userPassword(passwordEncoder.encode(request.userPassword()))
                .userName(request.userName())
                .userNickname(request.userNickname())
                .userPhoneNumber(request.userPhoneNumber())
                .build();
    }

    public void UserInfoUpdate(UserInfoUpdateRequest request) {
        if (request.userName() != null && !request.userName().isEmpty() && !request.userName().equals(this.userName)) {
            this.userName = request.userName();
        }
        if (request.userNickname() != null && !request.userNickname().isEmpty() && !request.userNickname().equals(this.userNickname)) {
            this.userNickname = request.userNickname();
        }
        if (request.userPhoneNumber() != null && !request.userPhoneNumber().isEmpty() && !request.userPhoneNumber().equals(this.userPhoneNumber)) {
            this.userPhoneNumber = request.userPhoneNumber();
        }
    }

}
