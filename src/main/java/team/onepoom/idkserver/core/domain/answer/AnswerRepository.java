package team.onepoom.idkserver.core.domain.answer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    boolean existsByQuestionIdAndUserId(long questionId, long writerId);
    Page<Answer> findAllByUserId(long userId, Pageable pageable);
    int countAllByQuestionId(long questionId);
}
