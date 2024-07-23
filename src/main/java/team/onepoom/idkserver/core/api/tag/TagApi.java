package team.onepoom.idkserver.core.api.tag;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;

interface TagApi {
    @Operation(summary = "인기 태그 목록 조회", description = "사이드바의 인기태그 목록을 조회하는 API", tags = { "태그"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "401", description = "로그인 만료일 경우")})
    List<TagRankResponse> findTagRanks();
}
