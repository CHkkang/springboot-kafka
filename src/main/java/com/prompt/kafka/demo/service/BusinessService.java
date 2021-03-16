package com.prompt.kafka.demo.service;

import com.prompt.kafka.demo.models.Business;
import com.prompt.kafka.demo.repo.BusinessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BusinessService {
    private final BusinessRepository businessRepository;
    @Transactional
    public Long save(Business requestDto) {
        return businessRepository.save(requestDto).getId();
    }

}
