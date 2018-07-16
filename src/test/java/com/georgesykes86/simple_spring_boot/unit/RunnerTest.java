package com.georgesykes86.simple_spring_boot.unit;

import static org.junit.Assert.assertEquals;

import com.georgesykes86.simple_spring_boot.Runner;
import org.junit.Before;
import org.junit.Test;

public class RunnerTest {
  private final String name = "George";
  private final int speed = 20;
  private final Long id = Long.valueOf(123);

  private Runner runner;

  @Before
  public void before() {
    runner = new Runner(name, speed);
    runner.setId(id);
  }

  @Test
  public void hasCorrectName() {
    assertEquals(name, runner.getName());
  }

  @Test
  public void hasCorrectSpeed() {
    assertEquals(speed, runner.getSpeed());
  }

}
