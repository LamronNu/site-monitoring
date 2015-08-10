package com.example.service;

import com.example.entity.Check;
import com.example.repository.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckService {

    @Autowired
    private CheckRepository checkRepository;

    public List<Check> findAll() {
        return checkRepository.findAll();
    }

    public void save(Check check) {
        checkRepository.save(check);
    }

    public void remove(Check check) {
        checkRepository.delete(check);
    }
}
