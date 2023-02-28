package com.mywebnotebook.notebook.repository;

import com.mywebnotebook.notebook.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {

    Guest findByEmail(String email);
}
