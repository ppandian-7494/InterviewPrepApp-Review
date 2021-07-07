package com.iptech.interviewprepapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iptech.interviewprepapp.domain.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>{

}
