package team.onepoom.idkserver.core.api.notice;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import team.onepoom.idkserver.core.domain.common.Provider;
import team.onepoom.idkserver.core.domain.notice.Notice;
import team.onepoom.idkserver.core.domain.notice.NoticeService;

@RestController
@RequestMapping("api/notices")
@RequiredArgsConstructor
class NoticeController implements NoticeApi{
    private final NoticeService noticeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(Provider provider, @RequestBody CreateNoticeRequest request) {
        /*
        Notice notice = request.toEntity(provider);
        noticeService.create(notice);
        */
        noticeService.create(request.toEntity(provider));
    }

    @PutMapping("{id}")
    public void modify(@PathVariable long id, @RequestBody ModifyNoticeRequest request) {

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {

    }

    @GetMapping("{id}")
    public GetOneNoticeResponse getNotice(@PathVariable long id) {
        return null;
    }

    @GetMapping
    public Page<FindNoticeResponse> findNotices(Pageable pageable) {
        return null;
    }

    @Override
    @GetMapping("mini")
    public List<FindMiniNoticeResponse> findMiniNotices(Pageable pageable) {
        return null;
    }
}
