package team.onepoom.idkserver.core.api.question;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team.onepoom.idkserver.core.domain.User;
import team.onepoom.idkserver.core.domain.common.Role;

@Getter
@NoArgsConstructor
public class WriterDTO {

    private Long id;
    private String email;
//    private List<Role> roles;

    public WriterDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
    }
}
