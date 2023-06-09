package com.eric.bookmanage.domain.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eric.bookmanage.common.Response;
import com.eric.bookmanage.domain.entity.Books;
import com.eric.bookmanage.domain.service.IBooksService;
import com.eric.bookmanage.domain.validation.books.NotConflictBooks;
import com.eric.bookmanage.domain.validation.books.UniqueBooks;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@Validated
public class BooksController {

    private static final Logger log = LoggerFactory.getLogger(BooksController.class);

    @Autowired
    private IBooksService booksService;

    @Operation(summary = "新增书籍")
    @PostMapping(produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "成功",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))}),
        @ApiResponse(responseCode = "400", description = "参数错误",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))}),
        @ApiResponse(responseCode = "500", description = "服务器错误",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))})
    })
    public Response addBook(@UniqueBooks @Validated @RequestBody Books books) {
        booksService.save(books);
        return Response.success();
    }

    @Operation(summary = "更新书籍")
    @PutMapping(produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "成功",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))}),
        @ApiResponse(responseCode = "400", description = "参数错误",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))}),
        @ApiResponse(responseCode = "500", description = "服务器错误",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))})
    })
    public Response editBook(@NotConflictBooks @Validated @RequestBody Books books) {
        booksService.updateById(books);
        return Response.success();
    }

    @Operation(summary = "获取书籍")
    @GetMapping(value = "/{id}", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "成功",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))}),
        @ApiResponse(responseCode = "400", description = "参数错误",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))}),
        @ApiResponse(responseCode = "500", description = "服务器错误",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))})
    })
    public Response getBook(@PathVariable Integer id) {
        log.info("获取书籍id:{}", id);
        return Response.success(booksService.getById(id));
    }
}
