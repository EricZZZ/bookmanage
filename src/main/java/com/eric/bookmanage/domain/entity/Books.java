package com.eric.bookmanage.domain.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * <p>
 * 
 * </p>
 *
 * @author EricZhao
 * @since 2023-04-25
 */
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(title = "书名")
    @NotBlank(message = "书名不能为空")
    private String title;

    @Schema(title = "作者")
    @NotBlank(message = "作者不能为空")
    private String author;

    @Schema(title = "价格")
    @NotBlank(message = "价格不能为空")
    private Double price;

    @Schema(title = "发布时间")
    @Past(message = "发布时间不能小于当前时间")
    private String publishDate;

    @Schema(title = "描述")
    @NotBlank(message = "描述不能为空")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id = " + id +
                ", title = " + title +
                ", author = " + author +
                ", price = " + price +
                ", publishDate = " + publishDate +
                ", description = " + description +
                "}";
    }
}
