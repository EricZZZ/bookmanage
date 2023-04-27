package com.eric.bookmanage.domain.validation.books;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.function.Predicate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.eric.bookmanage.domain.entity.Books;
import com.eric.bookmanage.domain.service.IBooksService;

public class BooksValidation<T extends Annotation> implements ConstraintValidator<T, Books> {

    @Autowired
    protected IBooksService iBooksService;

    protected Predicate<Books> predicate = c -> true;

    @Override
    public boolean isValid(Books value, ConstraintValidatorContext context) {
        return iBooksService == null || predicate.test(value);
    }

    public static class NotConflictBooksValidator extends BooksValidation<NotConflictBooks> {
        public void initlize(NotConflictBooks constraintAnnotation) {
            predicate = c -> {
                Collection<Books> list = iBooksService.lambdaQuery().eq(Books::getTitle, c.getTitle())
                        .eq(Books::getAuthor, c.getAuthor()).eq(Books::getPublishDate, c.getPublishDate()).list();
                        // 作者，出版日期，标题，是否有重复
                return list.isEmpty() || (list.size() == 1 && list.iterator().next().getId().equals(c.getId()));
            };
        }
    }

}