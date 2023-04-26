package com.eric.bookmanage.domain.service.impl;

import com.eric.bookmanage.domain.entity.OrderItems;
import com.eric.bookmanage.domain.mapper.OrderItemsMapper;
import com.eric.bookmanage.domain.service.IOrderItemsService;
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
public class OrderItemsServiceImpl extends ServiceImpl<OrderItemsMapper, OrderItems> implements IOrderItemsService {

}
