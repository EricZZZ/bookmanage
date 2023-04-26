package com.eric.bookmanage.domain.service.impl;

import com.eric.bookmanage.domain.entity.Books;
import com.eric.bookmanage.domain.mapper.BooksMapper;
import com.eric.bookmanage.domain.service.IBooksService;
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
public class BooksServiceImpl extends ServiceImpl<BooksMapper, Books> implements IBooksService {

}
