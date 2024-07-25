package team.onepoom.idkserver.core.api.answer;

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

@RequiredArgsConstructor
@RestController
@RequestMapping("api/answers")
class AnswerController implements AnswerApi{

    private final AnswerService answerService;

    @PostMapping("{id}/selections")
    public void select(@PathVariable long id, Provider provider) {

    }

    @DeleteMapping("{id}/selections")
    public void unselect(@PathVariable long id, Provider provider) {

    }

    @PutMapping("{id}")
    public void modify(Provider provider, @PathVariable long id, @RequestBody ModifyAnswerRequest request) {
        Answer newAnswer = new Answer(id, request.content());
        answerService.update(provider, newAnswer);
    }


    @DeleteMapping("{id}")
    public void delete(Provider provider, @PathVariable long id) {
        answerService.delete(provider, id);
    }


    @GetMapping("me")
    public Page<FindMyAnswerResponse> findAnswers(Provider provider, Pageable pageable) {
        return answerService.findAll(provider, pageable).map(FindMyAnswerResponse::from);
    }


    @PostMapping("{id}/reports")
    public void reportAnswer(Provider provider, @PathVariable long id) {

    }

    @PostMapping("{id}/likes")
    public void like(Provider provider, long id) {

    }


    @DeleteMapping("{id}/likes")
    public void dislike(Provider provider, long id) {

    }
}
