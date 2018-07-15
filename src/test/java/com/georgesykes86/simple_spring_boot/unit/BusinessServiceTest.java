package com.georgesykes86.simple_spring_boot.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.georgesykes86.simple_spring_boot.BusinessService;
import com.georgesykes86.simple_spring_boot.DataService;
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

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void returnsDefaultValue() {
    when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
    assertEquals(Integer.MIN_VALUE, businessService.findLargestValue());
  }

  @Test
  public void returnsLargestValue() {
    when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {2,3,4});
    assertEquals(4, businessService.findLargestValue());
  }

  @Test
  public void returnsAnotherLargestValue() {
    when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {2,3,5, 100});
    assertEquals(100, businessService.findLargestValue());
  }

}
