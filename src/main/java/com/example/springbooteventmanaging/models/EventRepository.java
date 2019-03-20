package com.example.springbooteventmanaging.models;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EventRepository extends JpaRepository<Event, Long>

{


}
