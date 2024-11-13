package doit.blog.controller.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@Entity // 해당 어노테이션이 필요한 이유?
@NoArgsConstructor
public class User { //User 클래스로 이름 짓는게 안좋은 이유

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
