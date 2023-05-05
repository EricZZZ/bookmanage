package com.eric.bookmanage.domain.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eric.bookmanage.common.exception.BaseException;
import com.eric.bookmanage.domain.entity.Users;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author EricZhao
 * @since 2023-04-25
 */
public interface IUsersService extends IService<Users> {

    public UserDetails loadUserByUsername(String username) throws BaseException;

}
