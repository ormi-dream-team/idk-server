package team.onepoom.idkserver.core.domain.exception;

public class AnswerConflictException extends ConflictException {

    public AnswerConflictException() {
        super("해당유저는 더이상 답변을 작성할 수 없습니다.");
    }
}
