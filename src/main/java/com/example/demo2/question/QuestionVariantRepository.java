package com.example.demo2.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuestionVariantRepository extends JpaRepository<QuestionEntity, UUID> {
}
