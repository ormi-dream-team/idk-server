package team.onepoom.idkserver.core.domain.question;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.onepoom.idkserver.core.api.question.CreateQuestionRequest;
import team.onepoom.idkserver.core.api.question.FindQuestionQuery;
import team.onepoom.idkserver.core.api.question.GetQuestionDetailResponse;
import team.onepoom.idkserver.core.api.question.GetQuestionResponse;
import team.onepoom.idkserver.core.api.question.ModifyQuestionRequest;
import team.onepoom.idkserver.core.domain.common.Provider;
import team.onepoom.idkserver.core.domain.common.Role;
import team.onepoom.idkserver.core.domain.exception.QuestionForbiddenException;
import team.onepoom.idkserver.core.domain.exception.QuestionNotFoundException;
import team.onepoom.idkserver.core.domain.user.User;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    //질문 작성
    @Transactional
    public void createQuestion(Provider provider, CreateQuestionRequest request) {
        User writer = new User(provider.id());
        Question question = Question.builder().writer(writer).title(request.title())
            .content(request.content()).build();
        questionRepository.save(question);
    }

    //단일 질문 조회
    public GetQuestionDetailResponse getOneQuestion(Provider provider, Long id) { //todo provider -> 답변 좋아요 체크
        Question question = questionRepository.findById(id)
            .orElseThrow(() -> new QuestionNotFoundException(id));

        return new GetQuestionDetailResponse(question);
    }

    //질문 목록 조회
    public Page<GetQuestionResponse> findQuestions(FindQuestionQuery query, Pageable pageable) {
        return questionRepository.findQuestions(query, pageable);
    }

    //내 질문 조회
    public Page<GetQuestionResponse> findMyQuestions(Provider provider, Pageable pageable) {
        return questionRepository.findMyQuestions(provider, pageable);
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
        if (provider.id() != question.getWriter().getId() || provider.roles().contains(Role.ADMIN)) {
            throw new QuestionForbiddenException(question.getId());
        }
    }

    //질문 삭제 권한 검증
    private void validateDeleteAuthority(Provider provider, Question question) {
        if (provider.id() != question.getWriter().getId() || provider.roles().contains(Role.ADMIN)) {
            throw new QuestionForbiddenException(question.getId());
        }
    }

    //Todo 질문 삭제 조건 검증
    private void validateDeleteCondition(Question question) {
        //질문의 답변이 존재할 시 Exception
    }

}
