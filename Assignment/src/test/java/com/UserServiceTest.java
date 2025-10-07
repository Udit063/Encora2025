package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.entity.Users;
import com.repository.UserRepository;
import com.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepo;
    
    @InjectMocks
    private UserService userService;
    
    @Test
    void shouldReturnUserName_whenUserExists() {

        Users user = new Users(1L, "Udit");
        when(userRepo.findById(1L)).thenReturn(Optional.of(user));


        String res = userService.getUserNameById(1L);

        assertEquals("Udit", res);
        verify(userRepo).findById(1L);
    }
    
    
    
    @Test
    void shouldReturnUnknown_whenUserDoesNotExists() {
        when(userRepo.findById(2L)).thenReturn(Optional.empty());

        String res = userService.getUserNameById(2L);

        assertEquals("Unknown", res);
    }
}
