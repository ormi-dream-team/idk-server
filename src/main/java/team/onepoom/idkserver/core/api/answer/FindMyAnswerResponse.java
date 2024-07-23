package team.onepoom.idkserver.core.api.answer;

import java.time.ZonedDateTime;
import java.util.List;
import team.onepoom.idkserver.core.domain.common.Provider;

record FindMyAnswerResponse(long id, Provider writer, String title, String content,
                            boolean isSelect, int answerCount, List<String> tags, AnswerResponse myAnswer,
                            ZonedDateTime createdAt, ZonedDateTime updatedAt) {
    private record AnswerResponse(long id, String content, boolean isSelected,
                                  int likeCount, ZonedDateTime createdAt,
                                  ZonedDateTime updatedAt) {

    }

}
