package com.georgesykes86.simple_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;

public class BusinessService {

  @Autowired
  DataService dataService;

  public int findLargestValue() {
    int[] data = dataService.retrieveAllData();
    int smallest = Integer.MIN_VALUE;
    return smallest;
  }
}
