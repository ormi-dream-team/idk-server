package team.onepoom.idkserver.core.domain.exception;

public class AnswerNotFoundException extends NotFoundException {

    public AnswerNotFoundException(long id) {
        super("존재하지 않는 질문입니다. id: " + id);
    }
}
