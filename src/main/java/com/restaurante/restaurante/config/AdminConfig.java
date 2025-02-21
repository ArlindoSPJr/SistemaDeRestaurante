package com.restaurante.restaurante.config;

import com.restaurante.restaurante.model.entities.Admin;
import com.restaurante.restaurante.model.repositories.AdminRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminConfig implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminConfig(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var admin = adminRepository.findByLogin("admin@gmail.com");
        if (admin == null) {
            var novoAdmin = new Admin("admin@gmail.com", passwordEncoder.encode("123"));
            adminRepository.save(novoAdmin);
            System.out.println("Admin criado com sucesso!");
        } else {
            System.out.println("Admin ja existente!");
        }
    }

}
