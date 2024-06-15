package com.example.demo.repository;

import com.example.demo.model.NHANVIEN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NHANVIENRepository extends JpaRepository<NHANVIEN, String> {
}
