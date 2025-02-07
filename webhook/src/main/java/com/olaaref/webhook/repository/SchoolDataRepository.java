package com.olaaref.webhook.repository;

import com.olaaref.webhook.model.SchoolData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolDataRepository extends JpaRepository<SchoolData, Long> {
}
