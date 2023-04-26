package com.eric.bookmanage.domain.service.impl;

import com.eric.bookmanage.domain.entity.ShoppingCart;
import com.eric.bookmanage.domain.mapper.ShoppingCartMapper;
import com.eric.bookmanage.domain.service.IShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author EricZhao
 * @since 2023-04-25
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements IShoppingCartService {

}
