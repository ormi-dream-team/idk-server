package team.onepoom.idkserver.core.api.answer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import team.onepoom.idkserver.core.domain.common.Provider;

interface AnswerApi {

    @Operation(summary = "답변 채택", description = "질문 작성자가 답변을 채택하는 API", tags = {"답변", "채택"})
    @ApiResponses(value = {@ApiResponse(responseCode = "404", description = "답변을 찾을 수 없을 경우"),
        @ApiResponse(responseCode = "403", description = "질문 작성자가 아닌 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    void select(@PathVariable long id, Provider provider);

    @Operation(summary = "답변 채택 취소", description = "질문 작성자가 답변 채택을 취소하는 API", tags = {"답변"})
    @ApiResponses(value = {@ApiResponse(responseCode = "404", description = "답변을 찾을 수 없을 경우"),
        @ApiResponse(responseCode = "403", description = "질문 작성자가 아닌 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    void unselect(@PathVariable long id, Provider provider);

    @Operation(summary = "답변 수정", description = "답변 작성자가 답변을 작성하는 API", tags = {"답변"})
    @ApiResponses(value = {@ApiResponse(responseCode = "400", description = "내용 2자 이상"),
        @ApiResponse(responseCode = "404", description = "답변을 찾을 수 없을 경우"),
        @ApiResponse(responseCode = "403", description = "답변 작성자가 아닐 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    void modify(Provider provider, @PathVariable long id, @RequestBody ModifyAnswerRequest request);

    @Operation(summary = "답변 삭제", description = "답변 작성자가 답변을 삭제하는 API", tags = {"답변"})
    @ApiResponses(value = {@ApiResponse(responseCode = "404", description = "답변을 찾을 수 없을 경우"),
        @ApiResponse(responseCode = "403", description = "답변 작성자가 아닐 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    void delete(Provider provider, @PathVariable long id);

    @Operation(summary = "내가 한 답변목록 조회", description = "내가 답변을 작성한 답변과 해당 질문을 목록으로 조회", tags = {
        "답변"})
    @ApiResponses(value = {@ApiResponse(responseCode = "403", description = "로그인 사용자가 아닐 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    Page<FindMyAnswerResponse> findQuestions(Provider provider, Pageable pageable);

    @Operation(summary = "답변 신고", description = "로그인 사용자가 답변을 신고하는 API", tags = {
        "답변", "신고"})
    @ApiResponses(value = {@ApiResponse(responseCode = "403", description = "로그인 사용자가 아닐 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    void reportQuestion(Provider provider, @PathVariable long id);

    @Operation(summary = "답변 좋아요", description = "로그인 사용자가 답변을 좋아요하는 API", tags = {
        "답변", "좋아요"})
    @ApiResponses(value = {@ApiResponse(responseCode = "403", description = "로그인 사용자가 아닐 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    void like(Provider provider, @PathVariable long id);
    @Operation(summary = "답변 좋아요 취소", description = "로그인 사용자가 답변좋아요를 취소하는 API", tags = {
        "답변", "좋아요"})
    @ApiResponses(value = {@ApiResponse(responseCode = "403", description = "로그인 사용자가 아닐 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    void dislike(Provider provider, @PathVariable long id);
}
