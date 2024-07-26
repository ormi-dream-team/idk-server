package team.onepoom.idkserver.core.domain.exception;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException(long id) {
        super("존재하지 않는 사용자입니다. id: " + id);
    }
}
