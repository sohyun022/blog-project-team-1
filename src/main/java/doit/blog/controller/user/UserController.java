package doit.blog.controller.user;

import doit.blog.controller.user.dto.UserInfoResponse;
import doit.blog.controller.user.dto.UserLoginRequest;
import doit.blog.controller.user.dto.UserIdResponse;
import doit.blog.controller.user.dto.UserSignUpRequest;
import doit.blog.exception.CustomErrorInfo;
import doit.blog.exception.CustomException;
import doit.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController implements UserControllerDocs {

    private final UserService userService;

    @PostMapping("/validate") // docs의 역할은 뭔가??
    public ResponseEntity<?> checkDuplicateId(@RequestParam String id) {
        if(userService.isDuplicated(id)){
            throw new CustomException(CustomErrorInfo.ID_DUPLICATION);
        }
        return ResponseEntity.ok("사용 가능한 ID");
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody UserSignUpRequest userSignUpRequest) {

    }

    @PostMapping("/login")
    public UserIdResponse login(@RequestBody UserLoginRequest userLoginRequest) {
        return null;
    }

    @GetMapping("/{userId}")
    public UserInfoResponse getUserInfo(@PathVariable Long userId) {
        return null;
    }
}