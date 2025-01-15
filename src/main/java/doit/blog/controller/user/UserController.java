package doit.blog.controller.user;

import doit.blog.controller.user.dto.*;
import doit.blog.repository.UserRepository;
import doit.blog.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController implements UserControllerDocs {

    private final UserService userService;
    private final HttpSession session;
    private final UserRepository userRepository;

    @PostMapping("/validate")
    public void checkDuplicateId(@RequestParam String id) {
        userService.validateDuplicateId(id);
    }

    @PostMapping("/")
    public UserIdResponse signUp(@Valid @RequestBody UserSignUpRequest userSignUpRequest) {
        return userService.signUp(userSignUpRequest);
    }

    @PostMapping("/login")
    public UserIdResponse login(@RequestBody UserLoginRequest userLoginRequest) {
        UserIdResponse response = userService.login(userLoginRequest);
        session.setAttribute("user", response.userId());
        return response;
    }

    @PostMapping("/logout")
    public void logout() {
        Long userId = (Long)session.getAttribute("user");
        if (userId != null) {
            session.invalidate();
        }
    }

    @GetMapping("/info")
    public UserInfoResponse getUserInfo() {
        Long userId = (Long)session.getAttribute("user");
        return userService.getUserInfo(userId);
    }

    @GetMapping("/info/{userId}")
    public UserInfoResponse getOtherUserInfo(@PathVariable Long userId) {
        return userService.getUserInfo(userId);
    }

    @PutMapping("/info")
    public UserIdResponse updateUserInfo(UserInfoUpdateRequest userInfoUpdateRequest) {
        Long userId = (Long)session.getAttribute("user");
        return userService.updateUserInfo(userId, userInfoUpdateRequest);
    }

    @DeleteMapping("/info")
    public void deleteUserInfo() {
        Long userId = (Long)session.getAttribute("user");
        userService.deleteUserInfo(userId);
    }
}
