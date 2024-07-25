package team.onepoom.idkserver.core.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import team.onepoom.idkserver.core.domain.common.BaseEntity;
import team.onepoom.idkserver.core.domain.common.Role;

@Entity
@Table(name = "user_roles")
class UserRole extends BaseEntity {
    @Id @GeneratedValue
    private Long id;
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @JoinColumn(name = "role")
    @ManyToOne(fetch = FetchType.LAZY)
    private Role role = Role.USER;
}
