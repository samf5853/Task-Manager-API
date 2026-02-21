package com.fostersolutions.taskmanager.config;

import com.fostersolutions.taskmanager.models.ERole;
import com.fostersolutions.taskmanager.models.Role;
import com.fostersolutions.taskmanager.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        for (ERole role : ERole.values()) {
            roleRepository.findByName(role)
                    .orElseGet(() -> roleRepository.save(new Role(role)));
        }
    }
}
