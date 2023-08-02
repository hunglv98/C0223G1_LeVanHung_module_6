package com.example.demo.service;


import com.example.demo.model.Status;

import java.util.List;

public interface IStatusService {
    List<Status> getList();

    Status getById(Integer id);

    void createStatus(Status status);
}
