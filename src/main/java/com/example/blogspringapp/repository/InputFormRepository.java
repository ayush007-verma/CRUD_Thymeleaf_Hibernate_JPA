package com.example.blogspringapp.repository;


import com.example.blogspringapp.entity.InputForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputFormRepository extends JpaRepository<InputForm, Long> {

}
