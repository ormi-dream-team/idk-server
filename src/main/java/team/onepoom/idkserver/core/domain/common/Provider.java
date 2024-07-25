package team.onepoom.idkserver.core.domain.common;


import io.swagger.v3.oas.annotations.Hidden;
import java.util.Collection;

@Hidden
public record Provider(long id, String email, String nickname, Collection<Role> roles){
}
