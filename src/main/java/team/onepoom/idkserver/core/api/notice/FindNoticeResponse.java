package team.onepoom.idkserver.core.api.notice;

import java.time.ZonedDateTime;
import team.onepoom.idkserver.core.domain.common.Provider;

record FindNoticeResponse(long id, Provider writer, String title, String content,
                          ZonedDateTime createdAt, ZonedDateTime updatedAt) {

}
