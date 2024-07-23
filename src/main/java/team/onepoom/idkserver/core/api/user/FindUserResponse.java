package team.onepoom.idkserver.core.api.user;

import team.onepoom.idkserver.core.domain.common.Role;

public record FindUserResponse(long id, String email, Role role) {

}
