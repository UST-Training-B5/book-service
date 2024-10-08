package com.demo.repo;

import org.springframework.stereotype.Repository;

import com.demo.entity.BookEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long>{

}
