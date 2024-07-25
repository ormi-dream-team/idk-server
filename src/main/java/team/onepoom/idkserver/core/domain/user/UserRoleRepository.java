package team.onepoom.idkserver.core.domain.user;

import java.util.LinkedHashSet;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    LinkedHashSet<UserRole> findByUserEmail(String userEmail);
    LinkedHashSet<UserRole> findByUserId(Long userId);
}
