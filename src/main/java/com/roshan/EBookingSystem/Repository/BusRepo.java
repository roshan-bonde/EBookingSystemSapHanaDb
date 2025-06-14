package com.roshan.EBookingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roshan.EBookingSystem.Entity.Bus;

public interface BusRepo extends JpaRepository<Bus, String> {

}
