package team.onepoom.idkserver.core.domain.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u join fetch u.roles r where u.email = :email")
    Optional<User> findByEmail(String email);
}
