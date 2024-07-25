package team.onepoom.idkserver.core.domain.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import team.onepoom.idkserver.core.api.question.FindQuestionQuery;
import team.onepoom.idkserver.core.api.question.FindQuestionResponse;
import team.onepoom.idkserver.core.api.question.QuestionDTO;

public interface QuestionRepositoryCustom {

    Page<QuestionDTO> findQuestions(FindQuestionQuery query, Pageable pageable);
}
