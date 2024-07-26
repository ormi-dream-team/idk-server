package team.onepoom.idkserver.core.domain.question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team.onepoom.idkserver.core.api.question.CreateQuestionRequest;
import team.onepoom.idkserver.core.api.question.ModifyQuestionRequest;
import team.onepoom.idkserver.core.domain.common.BaseEntity;
import team.onepoom.idkserver.core.domain.common.Provider;
import team.onepoom.idkserver.core.domain.common.Role;
import team.onepoom.idkserver.core.domain.exception.QuestionForbiddenException;
import team.onepoom.idkserver.core.domain.user.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "questions")
public class Question extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id", nullable = false)
    private User writer;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 1000)
    private String content;

    @Column(nullable = false)
    private boolean isSelect;

    private ZonedDateTime reportedAt;

    //생성 메서드
    @Builder
    Question(User writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.isSelect = false;
    }

    public static Question of(Provider provider, CreateQuestionRequest request) {
        return Question.builder()
            .writer(new User(provider.id()))
            .title(request.title())
            .content(request.content())
            .build();
    }

    //수정 메서드
    void modifyQuestion(ModifyQuestionRequest request) {
        this.title = request.title();
        this.content = request.content();
    }

    //답변 채택 시
    public void answerSelected() {
        this.isSelect = true;
    }

    //질문 소유자 권한 체크
    public void checkQuestionOwner(Provider provider, Question question) {
        if (provider.id() != question.getWriter().getId() || provider.roles().contains(Role.ADMIN)) {
            throw new QuestionForbiddenException(question.getId());
        }
    }

    //Todo 질문 삭제 조건 검증
    public void validateDeleteCondition(Question question) {
        //질문의 답변이 존재할 시 Exception
    }
}
