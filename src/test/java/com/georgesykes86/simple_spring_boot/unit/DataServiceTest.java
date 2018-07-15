package com.georgesykes86.simple_spring_boot.unit;

import static org.junit.Assert.assertEquals;

import com.georgesykes86.simple_spring_boot.DataService;
import org.junit.Before;
import org.junit.Test;

public class DataServiceTest {
  private DataService service;
  private final int[] data = {1,2,3,4};

  @Before
  public void beforeEach() {
    service = new DataService();
  }

  @Test
  public void returnsDataArrayOfCorrectLength() {
    assertEquals(data.length, service.retrieveAllData().length);
  }


}
