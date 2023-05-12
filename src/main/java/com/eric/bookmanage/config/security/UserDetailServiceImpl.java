package com.eric.bookmanage.config.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eric.bookmanage.common.exception.BaseException;
import com.eric.bookmanage.common.exception.SystemErrorType;
import com.eric.bookmanage.domain.service.IUsersService;

/**
 * <p>
 * 获取用户
 * </p>
 * 
 * @author Eric
 * @since 2023-05-12
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IUsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Users user = usersService.lambdaQuery().eq(Users::getUsername,
        // username).one();
        Map<String, String> users = new HashMap<>();
        users.put("eric", passwordEncoder.encode("111111"));
        if (users.containsKey(username)) {
            return new AccountUser(1L, username, users.get(username), new ArrayList<>());
        }
        throw new BaseException(SystemErrorType.LOGGIN_NAME_OR_PASSWORD_FAILURE);
        // return new AccountUser(user.getId(), user.getUsername(), user.getPassword(),
        // getUserAuthority(user.getId()));
    }

    public List<GrantedAuthority> getUserAuthority(Long user_id) {
        // 获取权限
        return null;
    }

}
