package team.onepoom.idkserver.core.domain.question;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.onepoom.idkserver.core.api.question.CreateQuestionRequest;
import team.onepoom.idkserver.core.api.question.FindQuestionQuery;
import team.onepoom.idkserver.core.api.question.FindQuestionResponse;
import team.onepoom.idkserver.core.api.question.GetOneQuestionResponse;
import team.onepoom.idkserver.core.api.question.ModifyQuestionRequest;
import team.onepoom.idkserver.core.api.question.QuestionDTO;
import team.onepoom.idkserver.core.domain.User;
import team.onepoom.idkserver.core.domain.common.Provider;
import team.onepoom.idkserver.core.domain.common.Role;
import team.onepoom.idkserver.core.domain.exception.QuestionForbiddenException;
import team.onepoom.idkserver.core.domain.exception.QuestionNotFoundException;
import team.onepoom.idkserver.core.domain.exception.UserNotFoundException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    //질문 작성
    @Transactional
    public void createQuestion(Provider provider, CreateQuestionRequest request) {
        User user = new User(provider.id());
        Question question = Question.builder()
            .user(user)
            .title(request.title())
            .content(request.content())
            .build();
        questionRepository.save(question);
    }

    //단일 질문 조회
    public GetOneQuestionResponse getOneQuestion(Provider provider, Long id) {
        Question question = questionRepository.findById(id)
            .orElseThrow(() -> new QuestionNotFoundException(id));

        return new GetOneQuestionResponse(id, provider, question.getTitle(), question.getContent(),
            question.isSelect(), 0, null, null, question.getCreatedAt(),
            question.getUpdatedAt());
    }

    //질문 목록 조회
    public Page<QuestionDTO> findQuestions(FindQuestionQuery query, Pageable pageable) {
        List<QuestionDTO> questions = questionRepository.findByTitleContains(query.title(), pageable).stream()
            .map(QuestionDTO::new)
            .collect(Collectors.toList());

        return new PageImpl<>(questions, pageable, questions.size());
    }


    //질문 수정
    @Transactional
    public void modifyQuestion(Provider provider, long id, ModifyQuestionRequest request) {
        Question question = questionRepository.findById(id)
            .orElseThrow(() -> new QuestionNotFoundException(id));
        validateModifyAuthority(provider, question);
        question.modifyQuestion(request);
    }

    //질문 삭제
    @Transactional
    public void deleteQuestion(Provider provider, Long id) {
        Question question = questionRepository.findById(id)
            .orElseThrow(() -> new QuestionNotFoundException(id));
        validateDeleteAuthority(provider, question);
        validateDeleteCondition(question);
        questionRepository.delete(question);
    }

    //==검증 메서드==//

    //질문 수정 권한 검증
    private void validateModifyAuthority(Provider provider, Question question) {
        if (provider.id() != question.getUser().getId() || provider.roles().contains(Role.ADMIN)) {
            throw new QuestionForbiddenException(question.getId());
        }
    }

    //질문 삭제 권한 검증
    private void validateDeleteAuthority(Provider provider, Question question) {
        if (provider.id() != question.getUser().getId() || provider.roles().contains(Role.ADMIN)) {
            throw new QuestionForbiddenException(question.getId());
        }
    }

    //Todo 질문 삭제 조건 검증
    private void validateDeleteCondition(Question question) {
        //질문의 답변이 존재할 시 Exception
    }

}
