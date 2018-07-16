package com.georgesykes86.simple_spring_boot;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataService {

  @Autowired
  DataRepository repository;

  public List<Runner> retrieveAllData() {
    return repository.findAll();
  }
}
