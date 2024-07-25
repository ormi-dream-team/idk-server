package team.onepoom.idkserver.core.api.question;


import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

record CreateAnswerRequest(@NotBlank @Length(min = 2) String content) {


}
