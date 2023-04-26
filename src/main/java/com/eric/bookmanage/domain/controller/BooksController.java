package com.eric.bookmanage.domain.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eric.bookmanage.common.Response;
import com.eric.bookmanage.domain.entity.Books;
import com.eric.bookmanage.domain.service.IBooksService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author EricZhao
 * @since 2023-04-25
 */
@RestController
@RequestMapping("/books")
@Tag(name = "BooksController", description = "书籍管理")
public class BooksController {

    @Autowired
    private IBooksService booksService;

    @Operation(summary = "添加书籍")
    @PostMapping(value = "/addBook", produces = "application/json")
    public Response addBook(@Valid @RequestBody Books books) {
        booksService.save(books);
        return Response.success();
    }

}
