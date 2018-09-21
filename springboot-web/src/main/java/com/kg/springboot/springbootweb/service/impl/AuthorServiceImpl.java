package com.kg.springboot.springbootweb.service.impl;

import com.kg.springboot.springbootweb.dao.AuthorDao;
import com.kg.springboot.springbootweb.entity.Author;
import com.kg.springboot.springbootweb.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public int add(Author author) {
        return this.authorDao.add(author);
    }

    @Override
    public int update(Author author) {
        return this.authorDao.update(author);
    }

    @Override
    public int delete(Long id) {
        return this.authorDao.delete(id);
    }

    @Override
    public Author findAuthor(Long id) {
        return this.authorDao.findAuthor(id);
    }

    @Override
    public List<Author> findAuthorList() {
        return this.authorDao.findAuthorList();
    }
}
