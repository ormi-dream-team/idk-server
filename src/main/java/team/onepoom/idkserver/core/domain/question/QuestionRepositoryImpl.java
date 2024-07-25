package team.onepoom.idkserver.core.domain.question;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import team.onepoom.idkserver.core.api.question.FindQuestionQuery;
import team.onepoom.idkserver.core.api.question.FindQuestionResponse;
import team.onepoom.idkserver.core.api.question.QuestionDTO;

@Repository
public class QuestionRepositoryImpl implements QuestionRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<QuestionDTO> findQuestions(FindQuestionQuery query, Pageable pageable) {
        return null;
    }
}
