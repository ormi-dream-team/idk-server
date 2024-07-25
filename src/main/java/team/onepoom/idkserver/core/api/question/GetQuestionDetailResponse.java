package team.onepoom.idkserver.core.api.question;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.querydsl.core.annotations.QueryProjection;
import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team.onepoom.idkserver.core.domain.common.Provider;
import team.onepoom.idkserver.core.domain.question.Question;

@Getter
@NoArgsConstructor
public class GetQuestionDetailResponse {

    private long id;
    private Provider writer;
    private String title;
    private String content;
    @JsonProperty("isSelect")
    private boolean select;
    private int answerCount;
//    private List<TagDTO> tags; //todo
//    private List<AnswerDTO> answers; //todo
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private ZonedDateTime reportedAt;

    @QueryProjection
    public GetQuestionDetailResponse(Question question) {
        this.id = question.getId();
        this.writer = question.getUser().toProvider();
        this.title = question.getTitle();
        this.content = question.getContent();
        this.select = question.isSelect();
        this.answerCount = 0; //todo
        this.createdAt = question.getCreatedAt();
        this.updatedAt = question.getUpdatedAt();
        this.reportedAt = question.getReportedAt();
    }
}
