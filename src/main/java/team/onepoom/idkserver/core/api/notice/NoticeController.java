package team.onepoom.idkserver.core.api.notice;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/notices")
class NoticeController implements NoticeApi{

    @PostMapping
    public void create(@RequestBody CreateNoticeRequest request) {

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
    public List<FindMiniNoticeResponse> findMiniNotices(Pageable pageable) {
        return null;
    }
}
