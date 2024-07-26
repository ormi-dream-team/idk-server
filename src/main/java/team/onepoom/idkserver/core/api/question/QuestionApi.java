package team.onepoom.idkserver.core.api.question;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import team.onepoom.idkserver.core.domain.common.Provider;

interface QuestionApi {

    @Operation(summary = "답변 생성", description = "로그인 사용자가 답변을 작성하는 API", tags = {"답변", "질문"})
    @ApiResponses(value = {@ApiResponse(responseCode = "400", description = "내용 2자 이상"),
        @ApiResponse(responseCode = "404", description = "답변을 찾을 수 없을 경우"),
        @ApiResponse(responseCode = "403", description = "로그인 사용자가 아닐 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    void createQuestion(@PathVariable long id, Provider provider, @RequestBody CreateAnswerRequest request);

    @PostMapping
    @Operation(summary = "질문 작성", description = "로그인 사용자가 질문을 작성하는 API", tags = { "질문" })
    @ApiResponses(value = { @ApiResponse(responseCode = "400", description = "제목 2자 이상, 내용 2자 이상, 태그 10개 이하 "),
        @ApiResponse(responseCode = "403", description = "비로그인, 정지 사용자일 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    void createQuestion(Provider provider, @RequestBody CreateQuestionRequest request);

    @PutMapping("{id}")
    @Operation(summary = "질문 수정", description = "질문 작성자가 질문을 수정하는 API", tags = { "질문" })
    @ApiResponses(value = { @ApiResponse(responseCode = "400", description = "제목 2자 이상, 내용 2자 이상, 태그 10개 이하 "),
        @ApiResponse(responseCode = "404", description = "질문을 찾을 수 없을 경우"),
        @ApiResponse(responseCode = "403", description = "비로그인, 정지 사용자일 경우, 작성자가 아닐 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    void modify(Provider provider, @PathVariable long id, @RequestBody ModifyQuestionRequest request);

    @DeleteMapping("{id}")
    @Operation(summary = "질문 삭제", description = "질문 작성자가 질문을 삭제하는 API", tags = { "질문" })
    @ApiResponses(value = { @ApiResponse(responseCode = "400", description = "제목 2자 이상, 내용 2자 이상, 태그 10개 이하 "),
        @ApiResponse(responseCode = "404", description = "질문을 찾을 수 없을 경우"),
        @ApiResponse(responseCode = "403", description = "비로그인, 정지 사용자일 경우, 작성자가 아닐 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    void delete(Provider provider, @PathVariable long id);

    @GetMapping("{id}")
    @Operation(summary = "단일 질문 상세페이지 조회", description = "모든 사용자가 질문을 조회하는 API", tags = { "질문" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "404", description = "질문을 찾을 수 없을 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    GetQuestionDetailResponse getQuestion(Provider provider, @PathVariable long id);

    @GetMapping
    @Operation(summary = "질문 목록 조회", description = "모든 사용자가 질문을 조회하는 API", tags = { "질문" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "404", description = "질문을 찾을 수 없을 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    Page<GetQuestionResponse> findQuestions(FindQuestionQuery query, Pageable pageable);
    @GetMapping("me")
    @Operation(summary = "내가 한 질문 목록 조회", description = "로그인 사용자가 자신의 질문 목록을 조회하는 API", tags = { "질문" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우"),
        @ApiResponse(responseCode = "403", description = "비로그인 상태일 경우")})
    Page<GetQuestionResponse> findMyQuestions(Provider provider, Pageable pageable);

    @Operation(summary = "질문 신고", description = "로그인 사용자가 질문을 신고하는 API", tags = {
        "질문", "신고"})
    @ApiResponses(value = {@ApiResponse(responseCode = "403", description = "로그인 사용자가 아닐 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    void report(Provider provider, @PathVariable long id);
}
