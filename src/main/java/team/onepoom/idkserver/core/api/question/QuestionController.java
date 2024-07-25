package team.onepoom.idkserver.core.api.question;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.onepoom.idkserver.core.domain.common.Provider;
import team.onepoom.idkserver.core.domain.question.QuestionService;

@RestController
@RequestMapping("api/questions")
@RequiredArgsConstructor
class QuestionController implements QuestionApi{

    private final QuestionService questionService;

    @Override
    @PostMapping("{id}/answers")
    public void createQuestion(long id, Provider provider, CreateAnswerRequest request) {

    }

    @PostMapping
    public void createQuestion(@AuthenticationPrincipal Provider provider, @RequestBody CreateQuestionRequest request) {
        questionService.createQuestion(provider, request);
    }

    @PutMapping("{id}")
    public void modify(@AuthenticationPrincipal Provider provider, @PathVariable long id, @RequestBody ModifyQuestionRequest request) {
        questionService.modifyQuestion(provider, id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@AuthenticationPrincipal Provider provider, @PathVariable long id) {
        questionService.deleteQuestion(provider, id);
    }

    @GetMapping("{id}")
    public GetQuestionDetailResponse getQuestion(@AuthenticationPrincipal Provider provider, @PathVariable long id) {
        return questionService.getOneQuestion(provider, id);
    }

    @GetMapping
    public Page<GetQuestionResponse> findQuestions(FindQuestionQuery query, Pageable pageable) {
        return questionService.findQuestions(query, pageable);
    }
    @GetMapping("me")
    public Page<GetQuestionResponse> findMyQuestions(@AuthenticationPrincipal Provider provider, Pageable pageable) {
        return questionService.findMyQuestions(provider, pageable);
    }

    @Override
    @PostMapping("{id}/reports")
    public void report(Provider provider, @PathVariable long id) {

    }
}
