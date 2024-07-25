package team.onepoom.idkserver.core.api.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import team.onepoom.idkserver.core.domain.user.CreateUser;

record CreateUserRequest(@Email @NotBlank String email, @NotBlank @Length(min = 8) String password,
                         @NotBlank @Length(min = 2) String nickname) {
    CreateUser toDomain() {
        return new CreateUser(email, password, nickname);
    }
}
