package com.georgesykes86.simple_spring_boot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Runner, Long> {

}
