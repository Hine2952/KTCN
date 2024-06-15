package com.example.demo.repository;

import com.example.demo.model.NHANVIEN;
import com.example.demo.model.PHONGBAN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PHONGBANRepository extends JpaRepository<PHONGBAN, Long> {

}
