package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.*;

public interface BookRepo extends JpaRepository<Book, Long>{

}
