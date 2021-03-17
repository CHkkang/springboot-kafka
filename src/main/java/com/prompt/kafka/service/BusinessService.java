package com.prompt.kafka.service;

import com.prompt.kafka.models.Business;
import com.prompt.kafka.repository.BusinessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BusinessService {
    private final BusinessRepository businessRepository;

    @Transactional
    public Long save(Business business) {
        return businessRepository.save(business).getId();
    }

}
