package com.eric.bookmanage.domain.validation.books;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.function.Predicate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.eric.bookmanage.domain.entity.Books;
import com.eric.bookmanage.domain.service.IBooksService;

public class BooksValidation<T extends Annotation> implements ConstraintValidator<T, Books> {

    private static final Logger log = LoggerFactory.getLogger(BooksValidation.class);

    @Autowired
    protected IBooksService iBooksService;

    protected Predicate<Books> predicate = c -> true;

    @Override
    public boolean isValid(Books value, ConstraintValidatorContext context) {

        return iBooksService == null || predicate.test(value);
    }

    public static class NotConflictBooksValidator extends BooksValidation<NotConflictBooks> {
        @Override
        public void initialize(NotConflictBooks constraintAnnotation) {
            predicate = c -> {
                log.info("books is {} ", c);
                Collection<Books> list = iBooksService.lambdaQuery().eq(Books::getTitle, c.getTitle())
                        .eq(Books::getAuthor, c.getAuthor()).eq(Books::getPublishDate, c.getPublishDate()).list();
                // 作者，出版日期，标题与现有书籍有重复
                return list.isEmpty() || (list.size() == 1 && list.iterator().next().getId().equals(c.getId()));
            };
        }
    }

    public static class UniqueBooksValidator extends BooksValidation<UniqueBooks> {

        @Override
        public void initialize(UniqueBooks constraintAnnotation) {

            predicate = c -> {
                LambdaQueryWrapper<Books> lq = Wrappers.lambdaQuery();
                lq.eq(Books::getTitle, c.getTitle())
                        .eq(Books::getAuthor, c.getAuthor()).eq(Books::getPublishDate, c.getPublishDate());
                return iBooksService.count(lq) == 0;
            };
        };
    }

}