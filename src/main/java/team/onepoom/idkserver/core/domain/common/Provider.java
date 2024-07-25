package team.onepoom.idkserver.core.domain.common;


import io.swagger.v3.oas.annotations.Hidden;
import java.util.List;

@Hidden
public record Provider(long id, String email, List<Role> role) {

}
