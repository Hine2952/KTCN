package com.example.demo.service;

import com.example.demo.model.PHONGBAN;
import com.example.demo.repository.PHONGBANRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class PHONGBANService {
    private final PHONGBANRepository phongbanRepository;

    public List<PHONGBAN> getAllPhongBan() {
        return phongbanRepository.findAll();
    }
}
