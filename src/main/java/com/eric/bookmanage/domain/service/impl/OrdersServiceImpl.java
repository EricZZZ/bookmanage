package com.eric.bookmanage.domain.service.impl;

import com.eric.bookmanage.domain.entity.Orders;
import com.eric.bookmanage.domain.mapper.OrdersMapper;
import com.eric.bookmanage.domain.service.IOrdersService;
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
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

}
