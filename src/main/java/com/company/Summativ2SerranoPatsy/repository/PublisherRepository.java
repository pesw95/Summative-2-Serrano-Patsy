package com.company.Summativ2SerranoPatsy.repository;

import com.company.Summativ2SerranoPatsy.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
