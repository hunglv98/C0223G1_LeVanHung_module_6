package com.example.demo.service;

import com.example.demo.model.Status;
import com.example.demo.repo.IStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService implements IStatusService {
    @Autowired
    private IStatusRepository statusRepository;

    @Override
    public List<Status> getList() {
        return statusRepository.findAll();
    }

    @Override
    public Status getById(Integer id) {
        return statusRepository.findById(id).orElse(null);
    }

    @Override
    public void createStatus(Status status) {
        statusRepository.save(status);
    }
}
