package com.georgesykes86.simple_spring_boot.unit;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.georgesykes86.simple_spring_boot.BusinessService;
import com.georgesykes86.simple_spring_boot.HomeController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class ControllerTest {

  @Autowired
  private MockMvc mvc;

  @Mock
  BusinessService service;

  @InjectMocks
  HomeController homeController;

  @MockBean
  private HomeController controller;

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void indexRootReturnsGreeting() {
    when(controller.index()).thenCallRealMethod();
    assertEquals("Hi", controller.index());
  }

  @Test
  public void getLargestReturnsTheLargest() {
    when(service.findLargestValue()).thenReturn(5);
    assertEquals(5, homeController.maxValue());
  }

}
