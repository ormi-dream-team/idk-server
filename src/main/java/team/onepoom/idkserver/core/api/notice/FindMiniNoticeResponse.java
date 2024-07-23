package team.onepoom.idkserver.core.api.notice;

import java.time.ZonedDateTime;
import team.onepoom.idkserver.core.domain.common.Provider;

record FindMiniNoticeResponse(long id, Provider writer, String title, ZonedDateTime createdAt,
                              ZonedDateTime updatedAt) {

}
