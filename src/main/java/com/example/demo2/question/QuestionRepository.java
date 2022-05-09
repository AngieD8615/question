package com.example.demo2.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface QuestionRepository extends JpaRepository <QuestionEntity, UUID> {
}
