package com.georgesykes86.simple_spring_boot.feature;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.georgesykes86.simple_spring_boot.BusinessService;
import com.georgesykes86.simple_spring_boot.DataService;
import org.junit.Test;
import org.junit.runner.RunWith;
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

  @Test
  public void returnsDefaultValue() {
    when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
    assertEquals(Integer.MIN_VALUE, service.findLargestValue());
  }

  @Test
  public void returnsLargestValue() {
    when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {2,3,4});
    assertEquals(4, service.findLargestValue());
  }

  @Test
  public void returnsAnotherLargestValue() {
    when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {2,3,5, 100});
    assertEquals(100, service.findLargestValue());
  }

}
