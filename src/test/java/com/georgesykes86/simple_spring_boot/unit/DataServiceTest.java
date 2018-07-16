package com.georgesykes86.simple_spring_boot.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.georgesykes86.simple_spring_boot.DataRepository;
import com.georgesykes86.simple_spring_boot.DataService;
import com.georgesykes86.simple_spring_boot.Runner;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DataServiceTest {
  @Mock
  DataRepository repository;

  @InjectMocks
  private DataService service;

  @Mock
  Runner runner;

  @Mock
  Runner runner2;

  private final List<Runner> runners = new ArrayList();

  @Before
  public void beforeEach() {
    runners.add(runner);
    runners.add(runner2);
    MockitoAnnotations.initMocks(this);
    when(repository.findAll()).thenReturn(runners);
    service = new DataService();
  }

  @Test
  public void returnsDataArrayOfCorrectLength() {
    assertEquals(runners, service.retrieveAllData());
  }
}
