package com.georgesykes86.simple_spring_boot;

import org.springframework.stereotype.Service;

@Service
public class BusinessService {
  private DataService dataService;

  public BusinessService(DataService dataService) {
    super();
    this.dataService = dataService;
  }

  public int findLargestValue() {
    int[] data = dataService.retrieveAllData();
    int smallest = Integer.MIN_VALUE;
    for(int num : data) {
      if(num > smallest) { smallest = num; }
    }
    return smallest;
  }
}
