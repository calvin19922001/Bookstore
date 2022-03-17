package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.*;


public interface BookStoreRepo extends JpaRepository<BookStore, Long>{

}
