package cn.wyl.common.security;

import lombok.Data;

/**
 * @author wyl
 * @since 2021-12-22 21:33:11
 */
@Data
public class SecurityUtils {

    public static LoginUser getLoginUser() {
        return new LoginUser();
    }
}
