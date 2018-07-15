package com.georgesykes86.simple_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

  @Autowired
  private BusinessService service;

  @RequestMapping(value = "/")
  @ResponseBody
  public String index() {
    System.out.println("here");
    return "Hi";
  }

  @RequestMapping(value = "/max")
  @ResponseBody
  public int maxValue() {
    System.out.println(service.findLargestValue());
    return service.findLargestValue();
  }
}
