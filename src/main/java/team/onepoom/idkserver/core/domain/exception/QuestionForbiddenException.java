package team.onepoom.idkserver.core.domain.exception;

public class QuestionForbiddenException extends ForbiddenException {

    public QuestionForbiddenException(long id) {
        super("접근 권한이 없습니다. id: " + id);
    }
}