package team.onepoom.idkserver.core.api.question;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.onepoom.idkserver.core.domain.answer.Answer;
import team.onepoom.idkserver.core.domain.answer.AnswerService;
import team.onepoom.idkserver.core.domain.common.Provider;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/questions")
class QuestionController implements QuestionApi{

    private final AnswerService answerService;

    @PostMapping("{id}/answers")
    public void createAnswer(long id, Provider provider, @RequestBody CreateAnswerRequest request) {
        Answer answer = new Answer(provider.id(), id, request.content());
        answerService.create(answer);
    }

    @PostMapping
    public void createQuestion(Provider provider, @RequestBody CreateQuestionRequest request) {
    }


    @PutMapping("{id}")
    public void modify(Provider provider, @PathVariable long id, @RequestBody ModifyQuestionRequest request) {

    }

    @DeleteMapping("{id}")
    public void delete(Provider provider, @PathVariable long id) {

    }

    @GetMapping("{id}")
    public GetOneQuestionResponse getQuestion(Provider provider, @PathVariable long id) {
        return null;
    }

    @GetMapping
    public Page<FindQuestionResponse> findQuestions(FindQuestionQuery query, Pageable pageable) {
        return null;
    }
    @GetMapping("me")
    public Page<FindQuestionResponse> findMyQuestions(Provider provider, Pageable pageable) {
        return null;
    }

    @Override
    @PostMapping("{id}/reports")
    public void report(Provider provider, @PathVariable long id) {

    }
}
