package com.wyl.auth.security.util;

import cn.hutool.core.util.StrUtil;
import com.wyl.auth.security.constant.SecurityConstants;
import com.wyl.auth.security.service.WylUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SecurityUtils {

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户
     */
    private static WylUser getUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof WylUser) {
            return (WylUser) principal;
        }
        return null;
    }

    /**
     * 获取用户
     */
    public static WylUser getUser() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return getUser(authentication);
    }

    /**
     * 获取用户角色信息
     *
     * @return 角色集合
     */
    public List<Integer> getRoles() {
        Authentication authentication = getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<Integer> roleIds = new ArrayList<>();
        authorities.stream().filter(granted -> StrUtil.startWith(granted.getAuthority(), SecurityConstants.ROLE))
                .forEach(granted -> {
                    String id = StrUtil.removePrefix(granted.getAuthority(), SecurityConstants.ROLE);
                    roleIds.add(Integer.parseInt(id));
                });
        return roleIds;
    }

}
