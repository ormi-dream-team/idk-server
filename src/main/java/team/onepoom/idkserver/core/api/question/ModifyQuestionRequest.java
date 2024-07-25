package team.onepoom.idkserver.core.api.question;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import org.hibernate.validator.constraints.Length;

public record ModifyQuestionRequest(@NotBlank @Length(min = 2) String title,
                                    @NotBlank String content, @NotNull List<String> tags) {

}
