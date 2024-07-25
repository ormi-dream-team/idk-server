package team.onepoom.idkserver.core.api.question;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team.onepoom.idkserver.core.domain.question.Question;

@Getter
@NoArgsConstructor
public class QuestionDTO {

    private Long id;
    private WriterDTO writer;
    private String title;
    private String content;
    private boolean isSelect;
    private int answerCount;
//    private List<TagDTO> tags;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private ZonedDateTime reportedAt;

    public QuestionDTO(Question question) {
        this.id = question.getId();
        this.writer = new WriterDTO(question.getUser());
        this.title = question.getTitle();
        this.content = question.getContent();
        this.isSelect = question.isSelect();
        this.answerCount = 0;
        this.createdAt = question.getCreatedAt();
        this.updatedAt = question.getUpdatedAt();
        this.reportedAt = question.getReportedAt();
    }
}
