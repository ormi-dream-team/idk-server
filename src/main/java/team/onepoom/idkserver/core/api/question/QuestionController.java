package team.onepoom.idkserver.core.api.question;

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
import team.onepoom.idkserver.core.domain.common.Provider;

@RestController
@RequestMapping("api/questions")
class QuestionController implements QuestionApi{


    @Override
    @PostMapping("{id}/answers")
    public void createAnser(long id, Provider provider, CreateAnswerRequest request) {

    }

    @PostMapping
    public void createAnser(Provider provider, @RequestBody CreateQuestionRequest request) {

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
}
