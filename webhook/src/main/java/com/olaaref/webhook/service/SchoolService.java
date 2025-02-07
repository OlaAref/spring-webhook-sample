package com.olaaref.webhook.service;

import com.olaaref.webhook.model.SchoolData;
import com.olaaref.webhook.repository.SchoolDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchoolService {

    private final SchoolDataRepository schoolDataRepository;

    @Autowired
    public SchoolService(SchoolDataRepository schoolDataRepository) {
        this.schoolDataRepository = schoolDataRepository;
    }

    public SchoolData addSchool(SchoolData schoolData) {
        return schoolDataRepository.save(schoolData);
    }

    public Optional<SchoolData> findById(Long schoolId) {
        return schoolDataRepository.findById(schoolId);
    }
}
