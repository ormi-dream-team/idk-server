package team.onepoom.idkserver.core.api.tag;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tags")
class TagController implements TagApi {
    @GetMapping("ranks")
    public List<TagRankResponse> findTagRanks(){
        return null;
    }
}
