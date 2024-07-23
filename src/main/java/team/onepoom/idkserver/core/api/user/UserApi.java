package team.onepoom.idkserver.core.api.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import team.onepoom.idkserver.core.domain.common.Provider;

interface UserApi {
    @Operation(summary = "회원가입", description = "비로그인 사용자가 회원가입하는 API", tags = { "사용자" })
    @ApiResponses(value = { @ApiResponse(responseCode = "400", description = "이메일 형식 검수, 비밀번호 8자 이상, 닉네임 2자 이상"),
        @ApiResponse(responseCode = "404", description = "질문을 찾을 수 없을 경우"),
        @ApiResponse(responseCode = "403", description = "비로그인, 정지 사용자일 경우, 작성자가 아닐 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    void join(@RequestBody CreateUserRequest request);
    @Operation(summary = "회원탈퇴", description = "로그인 사용자가 탈퇴를 요청하는 API", tags = { "사용자" })
    @ApiResponses(value = { @ApiResponse(responseCode = "400", description = "이메일 형식 검수, 비밀번호 8자 이상, 닉네임 2자 이상"),
        @ApiResponse(responseCode = "404", description = "질문을 찾을 수 없을 경우"),
        @ApiResponse(responseCode = "403", description = "비로그인, 정지 사용자일 경우, 작성자가 아닐 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    void resign(Provider provider);
    @Operation(summary = "회원 정지", description = "관리자가 사용자를 정지하는 API", tags = { "사용자", "어드민" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없을 경우"),
        @ApiResponse(responseCode = "403", description = "관리자가 아닐 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    void suspend(Provider provider, @PathVariable long id);
    @Operation(summary = "정지 취소", description = "관리자가 사용자 정지상태를 해제하는 API", tags = { "사용자", "어드민" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없을 경우"),
        @ApiResponse(responseCode = "403", description = "관리자가 아닐 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    void unsuspend(Provider provider, @PathVariable long id);
    @Operation(summary = "사용자 목록조회", description = "관리자가 사용자 목록을 조회하는 API", tags = { "사용자", "어드민" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "403", description = "관리자가 아닐 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    Page<FindUserResponse> findUsers(Provider provider, Pageable pageable);
}
