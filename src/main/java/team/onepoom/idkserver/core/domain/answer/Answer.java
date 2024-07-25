package team.onepoom.idkserver.core.domain.answer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team.onepoom.idkserver.core.domain.Question;
import team.onepoom.idkserver.core.domain.common.BaseEntity;
import team.onepoom.idkserver.core.domain.user.User;

@Getter
@Entity
@Table(name = "answers")
@NoArgsConstructor
public class Answer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "writer_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "question_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    @Column(length = 1000, nullable = false)
    private String content;

    @Column(nullable = false)
    private ZonedDateTime reportedAt;

    @Column(nullable = false)
    private boolean isSelected;


    public Answer(long writerId, long questionId, String content) {
        this.user = new User(writerId);
        this.question = new Question(questionId);
        this.content = content;
    }

    public Answer(Long id, String content) {
        this.id = id;
        this.content = content;
    }


    void updateContent(String content) {
        this.content = content;
    }
}
