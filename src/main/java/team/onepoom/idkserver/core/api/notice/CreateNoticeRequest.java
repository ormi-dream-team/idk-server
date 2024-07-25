package team.onepoom.idkserver.core.api.notice;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import team.onepoom.idkserver.core.domain.common.Provider;
import team.onepoom.idkserver.core.domain.notice.Notice;

public record CreateNoticeRequest(@NotBlank @Length(min = 2) String title,
                                  @NotBlank @Length(min = 2) String content) {

    // DTO -> Entity 변환
    public Notice toEntity(Provider provider) {
        return new Notice(provider, title, content);
    }
}