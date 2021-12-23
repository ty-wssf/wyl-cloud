package cn.wyl.common.core.security;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyl
 * @since 2021-12-22 21:35:07
 */
@Data
public class LoginUser {

    private Long userId;
    private Long deptId;
    private List<Role> roles = new ArrayList<>();

    public boolean isAdmin() {
        return userId != null && 1L == userId;
    }

    public LoginUser addRole(Role role) {
        roles.add(role);
        return this;
    }

}
