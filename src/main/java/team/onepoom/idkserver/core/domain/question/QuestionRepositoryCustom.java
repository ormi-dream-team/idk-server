package team.onepoom.idkserver.core.domain.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import team.onepoom.idkserver.core.api.question.FindQuestionQuery;
import team.onepoom.idkserver.core.api.question.GetQuestionResponse;
import team.onepoom.idkserver.core.domain.common.Provider;

public interface QuestionRepositoryCustom {

    Page<GetQuestionResponse> findQuestions(FindQuestionQuery query, Pageable pageable);

    Page<GetQuestionResponse> findMyQuestions(Provider provider, Pageable pageable);
}
