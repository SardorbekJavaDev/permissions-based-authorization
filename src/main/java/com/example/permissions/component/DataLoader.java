package com.example.permissions.component;

import com.example.permissions.entity.Role;
import com.example.permissions.entity.User;
import com.example.permissions.entity.enums.Permission;
import com.example.permissions.entity.enums.RoleType;
import com.example.permissions.repository.RoleRepository;
import com.example.permissions.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.example.permissions.entity.enums.Permission.*;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Value("${spring.sql.init.mode}")
    String value;

    @Override
    public void run(String... args) {
        if (value.equals("always")) {
            Permission[] values = Permission.values();
            Role admin = roleRepository.save(
                    new Role(
                            "Admin",
                            RoleType.ROLE_ADMIN,
                            Arrays.asList(values),
                            "System Admin role"
                    )
            );

            Role user = roleRepository.save(
                    new Role(
                            "User",
                            RoleType.ROLE_USER,
                            Arrays.asList(ADD_COMMIT, EDIT_COMMIT, DELETE_MY_COMMIT),
                            "Simple User role"
                    )
            );

            userRepository.save(
                    new User(
                            "Sardor",
                            "@admin",
                            passwordEncoder.encode("root123"),
                            admin,
                            true

                    )
            );

            userRepository.save(
                    new User(
                            "Olim",
                            "@user",
                            passwordEncoder.encode("root123"),
                            user,
                            true

                    )
            );
        }
    }
}
