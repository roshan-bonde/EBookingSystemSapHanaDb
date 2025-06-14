package com.roshan.EBookingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roshan.EBookingSystem.Entity.Train;

public interface TrainRepo extends JpaRepository<Train, String> {

}
