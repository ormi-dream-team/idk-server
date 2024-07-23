package team.onepoom.idkserver.core.api.answer;


import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

record CreateAnswerRequest(@NotBlank @Length(min = 2) String content) {

}
