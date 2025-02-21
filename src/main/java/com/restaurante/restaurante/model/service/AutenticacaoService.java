package com.restaurante.restaurante.model.service;

import com.restaurante.restaurante.model.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    //esse metodo permite que o Spring Security
    // consulte o banco de dados para autenticar um
    // usuário com base no nome de usuário fornecido durante o processo de login.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return adminRepository.findByLogin(username);
    }
}
