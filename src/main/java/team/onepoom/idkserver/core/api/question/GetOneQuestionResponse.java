package team.onepoom.idkserver.core.api.question;

import java.time.ZonedDateTime;
import java.util.List;
import team.onepoom.idkserver.core.domain.common.Provider;

record GetOneQuestionResponse(long id, Provider writer, String title, String content,
                              boolean isSelect, int answerCount, List<String> tags, List<AnswerResponse> answers,
                              ZonedDateTime createdAt, ZonedDateTime updatedAt) {

    private record AnswerResponse(long id, Provider writer, String content, boolean isSelected,
                                  boolean isLiked, int likeCount, ZonedDateTime createdAt,
                                  ZonedDateTime updatedAt) {

    }
}
