package team.onepoom.idkserver.core.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team.onepoom.idkserver.core.domain.common.BaseEntity;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, length = 255)
    private String password;
    @OneToMany(mappedBy = "user")
    @Column(nullable = false)
    private List<UserRole> roles;

    public User(Long id) {
        this.id = id;
    }

}
