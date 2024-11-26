package doit.blog.controller.user;

import doit.blog.controller.user.dto.UserInfoResponse;
import doit.blog.controller.user.dto.UserLoginRequest;
import doit.blog.controller.user.dto.UserIdResponse;
import doit.blog.controller.user.dto.UserSignUpRequest;
import doit.blog.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController implements UserControllerDocs {

    private final UserService userService;
    private final HttpSession session;

    @PostMapping("/validate")
    public void checkDuplicateId(@RequestParam String id) {
        userService.validateDuplicateId(id);
    }

    @PostMapping("/signup")
    public UserIdResponse signUp(@RequestBody UserSignUpRequest userSignUpRequest) {
        return userService.signUp(userSignUpRequest);
    }

    @PostMapping("/login")
    public UserIdResponse login(@RequestBody UserLoginRequest userLoginRequest) {
        UserIdResponse response = userService.login(userLoginRequest);
        session.setAttribute("user", response.userId());
        return response;
    }

    @GetMapping("/info")
    public UserInfoResponse getUserInfo() {
        Long userId = (Long)session.getAttribute("user");
        return userService.getUserInfo(userId);
    }
}
