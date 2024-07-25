package team.onepoom.idkserver.core.api.user;

import java.util.Set;
import team.onepoom.idkserver.core.domain.common.Role;

public record FindUserResponse(long id, String email, Set<Role> roles) {

}
