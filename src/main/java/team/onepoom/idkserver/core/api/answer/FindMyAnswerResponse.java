package team.onepoom.idkserver.core.api.answer;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import team.onepoom.idkserver.core.domain.Question;
import team.onepoom.idkserver.core.domain.answer.Answer;
import team.onepoom.idkserver.core.domain.common.Provider;


/*
* 질문아이디
* 질문작성자
* 질문제목
* 질문내용
* 채택여부
* 답변수
* 태그리스트~
* 내 답변 AnswerResponse {
    답변아이디
    내답변내용
    내답변채택여부
    내답변좋아요수
    내답변생성일자
    내답변수정일자
* }
* 질문작성일자
* 질문수정일자
* */


record FindMyAnswerResponse(long questionId, Provider writer, String title, String content,
                            boolean isSelect, int answerCount, List<String> tags,
                            AnswerResponse myAnswer,
                            ZonedDateTime createdAt, ZonedDateTime updatedAt) {

    private record AnswerResponse(long answerId, String content, boolean isSelected,
                                  int likeCount, ZonedDateTime createdAt,
                                  ZonedDateTime updatedAt) {

        static AnswerResponse from(Answer answer) {
            return new AnswerResponse(answer.getId(),
                answer.getContent(),
                answer.isSelected(),
                0,
                answer.getCreatedAt(),
                answer.getUpdatedAt()
            );
        }
    }

    static FindMyAnswerResponse from (Answer answer) {
        Question question = answer.getQuestion();
        return new FindMyAnswerResponse(
            question.getId(),
            answer.getUser().toProvider(),
            question.getTitle(),
            question.getContent(),
            question.isSelect(),
            0,
            new ArrayList<>(),
            AnswerResponse.from(answer),
            question.getCreatedAt(),
            question.getUpdatedAt());
    }
}
