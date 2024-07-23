package team.onepoom.idkserver.core.api.notice;


import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

record ModifyNoticeRequest(@NotBlank @Length(min = 2) String title,
                           @NotBlank @Length(min = 2) String content) {

}
