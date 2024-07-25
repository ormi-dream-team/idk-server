package team.onepoom.idkserver.core.domain.answer;

import static team.onepoom.idkserver.core.domain.common.Role.ADMIN;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.onepoom.idkserver.core.domain.Question;
import team.onepoom.idkserver.core.domain.User;
import team.onepoom.idkserver.core.domain.common.Provider;
import team.onepoom.idkserver.core.domain.exception.AnswerConflictException;
import team.onepoom.idkserver.core.domain.exception.AnswerForbiddenException;
import team.onepoom.idkserver.core.domain.exception.AnswerNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Answer answer) {
        throwIfAnswerExists(answer.getQuestion(), answer.getUser());
        answerRepository.save(answer);
    }

    public Answer find(Long id) {
        return answerRepository.findById(id)
            .orElseThrow(() -> new AnswerNotFoundException(id));
    }

    public void update(Provider provider, Answer newAnswer) {
        checkAccessPermissionOfModify(provider, newAnswer);
        Answer answer = find(newAnswer.getId());
        answer.updateContent(newAnswer.getContent());
        answerRepository.save(answer);
    }


    public Page<Answer> findAll(Provider provider, Pageable pageable) {
        return answerRepository.findAllByUserId(provider.id(), pageable);
    }

    public void delete(Provider provider, long id) {
        Answer answer = find(id);
        checkAccessPermissionOfDelete(provider, answer);
        answerRepository.deleteById(id);
    }

    void throwIfAnswerExists(Question question, User user) {
        if (answerRepository.existsByQuestionIdAndUserId(question.getId(), user.getId())) {
            throw new AnswerConflictException();
        }
    }

    boolean isWriter (Provider provider, Answer answer) {
        return provider.id() == answer.getUser().getId();
    }

    boolean isAdmin (Provider provider) {
        return provider.role().contains(ADMIN);
    }

    void checkAccessPermissionOfModify(Provider provider, Answer answer) {
        if(isWriter(provider, answer)) {
            throw new AnswerForbiddenException();
        }
    }
    void checkAccessPermissionOfDelete(Provider provider, Answer answer) {
        if(!isWriter(provider, answer) && !isAdmin(provider)) {
            throw new AnswerForbiddenException();
        }
    }

}
