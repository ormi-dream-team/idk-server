package team.onepoom.idkserver.core.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.onepoom.idkserver.core.domain.common.Provider;
import team.onepoom.idkserver.core.domain.user.UserService;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController implements UserApi {
    private final UserService userService;
    @PostMapping("join")
    public void join(@RequestBody CreateUserRequest request) {
        userService.create(request.toDomain());
    }

    @DeleteMapping("me")
    public void resign(Provider provider) {

    }

    @PostMapping("{id}/roles")
    public void suspend(Provider provider, @PathVariable long id) {

    }

    @DeleteMapping("{id}/roles")
    public void unsuspend(Provider provider, @PathVariable long id) {

    }

    @GetMapping
    public Page<FindUserResponse> findUsers(Provider provider, Pageable pageable) {
        return null;
    }
    @GetMapping("me")
    public Provider getMe(@AuthenticationPrincipal Provider provider) {
        return provider;
    }
}
