package com.mywebnotebook.notebook.service;

import com.mywebnotebook.notebook.dto.RegistrationDto;
import com.mywebnotebook.notebook.entity.Guest;

public interface GuestService {
    void saveGuest(RegistrationDto registrationDto);

    Guest findByEmail(String email);
}
