package com.restaurante.restaurante.model.service;

import com.restaurante.restaurante.exceptions.ResourceNotFoundException;
import com.restaurante.restaurante.model.entities.Admin;
import com.restaurante.restaurante.model.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    public Admin getById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User nao encontrado com id" + id));
    }

    public void save(Admin adminTime) {

        if (adminRepository.existsAdminTimesByLogin(adminTime.getLogin())){
            throw new ResourceNotFoundException("Admin com login ja cadastrado!");
        }

        String senhaCriptografada = passwordEncoder.encode(adminTime.getPassword());
        adminTime.setPassword(senhaCriptografada);
        adminRepository.save(adminTime);
    }

    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }
}
