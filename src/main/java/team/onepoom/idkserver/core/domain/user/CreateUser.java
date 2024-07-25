package team.onepoom.idkserver.core.domain.user;

public record CreateUser(String email, String password, String nickname) {
    CreateUser insertEncodedPassword(String encoded) {
        return new CreateUser(email, encoded, nickname);
    }
}
