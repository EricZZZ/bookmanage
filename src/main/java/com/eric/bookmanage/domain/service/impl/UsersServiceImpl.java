package com.eric.bookmanage.domain.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
