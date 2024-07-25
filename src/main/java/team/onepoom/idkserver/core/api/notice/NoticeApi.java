package team.onepoom.idkserver.core.api.notice;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import team.onepoom.idkserver.core.domain.common.Provider;

interface NoticeApi {

    @Operation(summary = "공지사항 작성", description = "관리자가 공지사항을 작성하는 API", tags = { "공지사항" })
    @ApiResponses(value = { @ApiResponse(responseCode = "400", description = "제목 2자 이상, 내용 2자 이상"),
        @ApiResponse(responseCode = "403", description = "관리자가 아닐 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    void create(Provider provider, @RequestBody CreateNoticeRequest request);

    @Operation(summary = "공지사항 수정", description = "관리자가 공지사항을 수정하는 API", tags = { "공지사항" })
    @ApiResponses(value = { @ApiResponse(responseCode = "400", description = "제목 2자 이상, 내용 2자 이상"),
        @ApiResponse(responseCode = "404", description = "공지사항을 찾을 수 없을 경우"),
        @ApiResponse(responseCode = "403", description = "관리자가 아닐 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    void modify(@PathVariable long id, @RequestBody ModifyNoticeRequest request);

    @Operation(summary = "공지사항 삭제", description = "관리자가 공지사항을 삭제하는 API", tags = { "공지사항" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "404", description = "공지사항을 찾을 수 없을 경우"),
        @ApiResponse(responseCode = "403", description = "관리자가 아닐 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    void delete(@PathVariable long id);

    @Operation(summary = "공지사항 상세보기", description = "사용자가 공지사항 세부내용을 조회하는 API", tags = { "공지사항" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "404", description = "공지사항을 찾을 수 없을 경우"),
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    GetOneNoticeResponse getNotice(@PathVariable long id);

    @Operation(summary = "공지사항 전체 목록보기", description = "사용자가 공지사항 전체목록을 열람하는 API", tags = { "공지사항" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    Page<FindNoticeResponse> findNotices(Pageable pageable);

    @Operation(summary = "공지사항 5개만 요약해서 목록보기", description = "사용자가 공지사항 간소화 목록을 열람하는 API", tags = { "공지사항" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    List<FindMiniNoticeResponse> findMiniNotices(Pageable pageable);
}
