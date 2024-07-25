package team.onepoom.idkserver.core.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team.onepoom.idkserver.core.domain.common.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User extends BaseEntity {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, length = 255)
    private String password;

    public User(Long id) {
        this.id = id;
    }
}
