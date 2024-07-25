package team.onepoom.idkserver.core.domain.user;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import team.onepoom.idkserver.core.domain.common.BaseEntity;
import team.onepoom.idkserver.core.domain.common.Role;

@Entity
@Table(name = "user_roles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class UserRole extends BaseEntity {
    @Id @GeneratedValue
    private Long id;
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @Convert(converter = UserRoleConverter.class)
    private Role role;
    Role toRole() {
        return role;
    }

    UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }
}
