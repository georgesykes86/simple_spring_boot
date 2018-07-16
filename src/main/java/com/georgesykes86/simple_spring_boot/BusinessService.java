package com.georgesykes86.simple_spring_boot;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {
  private DataService dataService;

  public BusinessService(DataService dataService) {
    super();
    this.dataService = dataService;
  }

  public String findFastest() {
    List<Runner> data = dataService.retrieveAllData();
    if(data.isEmpty()) { return "Sorry no runners to compare"; }
    int fastest = data.get(0).getSpeed();
    String name = "";
    for(Runner runner : data) {
      if(runner.getSpeed() > fastest) {
        fastest = runner.getSpeed();
        name = runner.getName();
      } else if(runner.getSpeed() == fastest) {
        name = name + ", " + runner.getName();
      }
    }
    return name.substring(2);
  }
}
