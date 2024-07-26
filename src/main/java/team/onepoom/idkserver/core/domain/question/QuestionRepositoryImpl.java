package team.onepoom.idkserver.core.domain.question;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import team.onepoom.idkserver.core.api.question.FindQuestionQuery;
import team.onepoom.idkserver.core.api.question.GetQuestionResponse;
import team.onepoom.idkserver.core.api.question.QGetQuestionResponse;
import team.onepoom.idkserver.core.domain.common.Provider;

@Repository
@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<GetQuestionResponse> findQuestions(FindQuestionQuery findQuestionQuery, Pageable pageable) {

        List<GetQuestionResponse> questions = queryFactory
            .select(new QGetQuestionResponse(QQuestion.question))
            .from(QQuestion.question)
            .where(titleContains(findQuestionQuery.title()))
            .limit(pageable.getPageSize())
            .offset(pageable.getOffset())
            .fetch();

        return new PageImpl<>(questions, pageable, questions.size());
    }

    @Override
    public Page<GetQuestionResponse> findMyQuestions(Provider provider, Pageable pageable) {
        List<GetQuestionResponse> questions = queryFactory
            .select(new QGetQuestionResponse(QQuestion.question))
            .from(QQuestion.question)
            .where(QQuestion.question.writer.id.eq(provider.id()))
            .limit(pageable.getPageSize())
            .offset(pageable.getOffset())
            .fetch();

        return new PageImpl<>(questions, pageable, questions.size());
    }

    private BooleanExpression titleContains(String title) {
        return title != null ? QQuestion.question.title.contains(title) : null;
    }
}
