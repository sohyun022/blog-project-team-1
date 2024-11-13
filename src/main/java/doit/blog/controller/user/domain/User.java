package doit.blog.controller.user.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity // 해당 어노테이션이 필요한 이유?
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userLoginId;

    @NotNull // nullable 이랑 뭐가 다르지
    private String userPassword;

    @NotNull
    private String userName;

    @NotNull
    private String userNickname;

    private String userPhoneNumber;

}
