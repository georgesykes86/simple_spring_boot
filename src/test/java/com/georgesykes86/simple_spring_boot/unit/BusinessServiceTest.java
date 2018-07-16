package com.georgesykes86.simple_spring_boot.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.georgesykes86.simple_spring_boot.BusinessService;
import com.georgesykes86.simple_spring_boot.DataService;
import com.georgesykes86.simple_spring_boot.Runner;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BusinessServiceTest {
  @Mock
  DataService dataServiceMock;

  @InjectMocks
  BusinessService businessService;

  @Mock
  Runner runner;

  @Mock
  Runner runner2;

  private final List<Runner> runners = new ArrayList();

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);
    runners.add(runner);
    runners.add(runner2);
    when(runner.getSpeed()).thenReturn(20);
    when(runner.getName()).thenReturn("John");
  }

  @Test
  public void returnsDefaultValue() {
    when(dataServiceMock.retrieveAllData()).thenReturn(new ArrayList<>());
    assertEquals("Sorry no runners to compare", businessService.findFastest());
  }

  @Test
  public void returnsFastestRunner() {
    when(dataServiceMock.retrieveAllData()).thenReturn(runners);
    when(runner2.getSpeed()).thenReturn(10);
    assertEquals("John", businessService.findFastest());
  }

  @Test
  public void returnsFastestRunnersTogether() {
    when(dataServiceMock.retrieveAllData()).thenReturn(runners);
    when(runner2.getSpeed()).thenReturn(20);
    when(runner2.getName()).thenReturn("Ben");
    assertEquals("John, Ben", businessService.findFastest());
  }

}
