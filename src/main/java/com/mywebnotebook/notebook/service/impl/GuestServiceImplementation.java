//package com.mywebnotebook.notebook.service.impl;
//
//import com.mywebnotebook.notebook.dto.RegistrationDto;
//import com.mywebnotebook.notebook.entity.Guest;
//import com.mywebnotebook.notebook.entity.Role;
//import com.mywebnotebook.notebook.repository.GuestRepository;
//import com.mywebnotebook.notebook.repository.RoleRepository;
//import com.mywebnotebook.notebook.service.GuestService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//
//@Service
//public class GuestServiceImplementation implements GuestService {
//
//    private GuestRepository guestRepository;
//    private RoleRepository roleRepository;
//
//
//    public GuestServiceImplementation(GuestRepository guestRepository,
//                                      RoleRepository roleRepository)
//    {
//        this.guestRepository = guestRepository;
//        this.roleRepository=roleRepository;
//
//    }
//
//    @Override
//    public void saveGuest(RegistrationDto registrationDto) {
//        Guest guest = new Guest();
//        guest.setName(registrationDto.getFirstName()+" "+ registrationDto.getLastName());
//        guest.setEmail(registrationDto.getEmail());
////encrypt password with spring security
//        guest.setPassword(registrationDto.getPassword());
//        Role role = roleRepository.findByName("GUEST");
//        guest.setRoles(Arrays.asList(role));
//        guestRepository.save(guest);
//
//    }
//
//    @Override
//    public Guest findByEmail(String email) {
//        return guestRepository.findByEmail(email);
//    }
//}
