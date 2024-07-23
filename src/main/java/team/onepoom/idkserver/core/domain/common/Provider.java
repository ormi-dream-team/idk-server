package team.onepoom.idkserver.core.domain.common;


import io.swagger.v3.oas.annotations.Hidden;

@Hidden
public record Provider(long id, String email, Role role) {

}
