package com.georgesykes86.simple_spring_boot.feature;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.georgesykes86.simple_spring_boot.BusinessService;
import com.georgesykes86.simple_spring_boot.DataService;
import com.georgesykes86.simple_spring_boot.Runner;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessServiceContextTest {

  @MockBean
  DataService dataServiceMock;

  @Autowired
  BusinessService service;

  @Mock
  Runner runner;

  @Mock
  Runner runner2;

  private final List<Runner> runners = new ArrayList();

  @Before
  public void before() {
    runners.add(runner);
    runners.add(runner2);
  }

  @Test
  public void returnsDefaultValue() {
    when(dataServiceMock.retrieveAllData()).thenReturn(new ArrayList<>());
    assertEquals("Sorry no runners to compare", service.findFastest());
  }

  @Test
  public void returnsFastestRunner() {
    when(dataServiceMock.retrieveAllData()).thenReturn(runners);
    when(runner.getSpeed()).thenReturn(20);
    when(runner.getName()).thenReturn("John");
    when(runner2.getSpeed()).thenReturn(10);
    assertEquals("John", service.findFastest());
  }

}
