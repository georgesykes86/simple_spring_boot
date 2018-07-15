package com.georgesykes86.simple_spring_boot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "runners")
public class Runner {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "speed")
  private int speed;

  public Runner() {}

  public Runner(String name, int speed) {
    this.name = name;
    this.speed = speed;
  }

}
