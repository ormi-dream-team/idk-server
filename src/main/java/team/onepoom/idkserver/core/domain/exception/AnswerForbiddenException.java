package team.onepoom.idkserver.core.domain.exception;

public class AnswerForbiddenException extends ForbiddenException {

    public AnswerForbiddenException() {
        super("해당 리소스에 대한 권한이 없습니다.");
    }
}
