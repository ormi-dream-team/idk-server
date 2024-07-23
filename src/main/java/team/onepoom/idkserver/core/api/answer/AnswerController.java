package team.onepoom.idkserver.core.api.answer;

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
@RequestMapping("api/answers")
class AnswerController implements AnswerApi{

    @PostMapping
    public void create(Provider provider, @RequestBody CreateAnswerRequest request) {

    }

    @PostMapping("{id}/selections")
    public void select(@PathVariable long id, Provider provider) {

    }

    @DeleteMapping("{id}/selections")
    public void unselect(@PathVariable long id, Provider provider) {

    }

    @PutMapping("{id}")
    public void modify(Provider provider, @PathVariable long id, @RequestBody ModifyAnswerRequest request) {

    }

    @DeleteMapping("{id}")
    public void delete(Provider provider, @PathVariable long id) {

    }

    @Override
    @GetMapping("me")
    public Page<FindMyAnswerResponse> findQuestions(Provider provider, Pageable pageable) {
        return null;
    }

    @Override
    @PostMapping("{id}/reports")
    public void reportQuestion(Provider provider, @PathVariable long id) {

    }

    @Override
    @PostMapping("{id}/likes")
    public void like(Provider provider, long id) {

    }

    @Override
    @DeleteMapping("{id}/likes")
    public void dislike(Provider provider, long id) {

    }
}
