package team.onepoom.idkserver.core.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import team.onepoom.idkserver.core.domain.common.BaseEntity;

@Entity
@Table(name = "users")
class User extends BaseEntity {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, length = 255)
    private String password;
}
