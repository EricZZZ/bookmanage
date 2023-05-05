package com.eric.bookmanage.domain.service.impl;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eric.bookmanage.common.exception.BaseException;
import com.eric.bookmanage.common.exception.SystemErrorType;
import com.eric.bookmanage.config.security.AccountUser;
import com.eric.bookmanage.domain.entity.Users;
import com.eric.bookmanage.domain.mapper.UsersMapper;
import com.eric.bookmanage.domain.service.IUsersService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author EricZhao
 * @since 2023-04-25
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

    @Override
    public UserDetails loadUserByUsername(String username) throws BaseException {

        Users user = lambdaQuery().eq(Users::getUsername, username).one();
        if (user == null) {
            throw new BaseException(SystemErrorType.LOGGIN_NAME_OR_PASSWORD_FAILURE);
        }
        return new AccountUser(user.getId(), user.getUsername(), user.getPassword(),
                getUserAuthority(user.getId()));
    }

    public List<GrantedAuthority> getUserAuthority(Long user_id) {
        return null;
    }

}
