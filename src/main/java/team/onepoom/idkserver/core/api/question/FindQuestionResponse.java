package team.onepoom.idkserver.core.api.question;

import java.time.ZonedDateTime;
import java.util.List;
import team.onepoom.idkserver.core.domain.common.Provider;

record FindQuestionResponse(long id, Provider writer, String title, String content,
                            boolean isSelect, int answerCount, List<String> tags,
                            ZonedDateTime createdAt, ZonedDateTime updatedAt) {

}
