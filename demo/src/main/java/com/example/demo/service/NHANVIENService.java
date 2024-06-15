package com.example.demo.service;
import com.example.demo.model.NHANVIEN;
import com.example.demo.repository.NHANVIENRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class NHANVIENService {
    private final NHANVIENRepository nhanvienRepository;

    // Retrieve all NHANVIENs from the database
    public List<NHANVIEN> getAllNhanviens() {
        return nhanvienRepository.findAll();
    }
    // Retrieve a product by its id
    public Optional<NHANVIEN> getNhanVienById(String maNV) {
        return nhanvienRepository.findById(maNV);
    }
    // Add a new product to the database
    public NHANVIEN addNhanvien(NHANVIEN product) { return nhanvienRepository.save(product); }
    // Update an existing product
    public NHANVIEN updateNhanvien(String id, NHANVIEN nhanVienDetails) {
        NHANVIEN nhanVien = nhanvienRepository.findById(id).orElseThrow(() -> new RuntimeException("NhanVien not found"));
        nhanVien.setTen_NV(nhanVienDetails.getTen_NV());
        nhanVien.setPhai(nhanVienDetails.getPhai());
        nhanVien.setNoi_Sinh(nhanVienDetails.getNoi_Sinh());
        nhanVien.setMa_Phong(nhanVienDetails.getMa_Phong());
        nhanVien.setLuong(nhanVienDetails.getLuong());
        return nhanvienRepository.save(nhanVien);
    }
    // Delete a product by its id
    public void deleteNhanvienById(String id) {
        if (!nhanvienRepository.existsById(id)) {
            throw new IllegalStateException("Nhanvien with ID " + id + " does not exist.");
        }
        nhanvienRepository.deleteById(id);
    }
    public Page<NHANVIEN> findPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return nhanvienRepository.findAll(pageable);
    }
}
