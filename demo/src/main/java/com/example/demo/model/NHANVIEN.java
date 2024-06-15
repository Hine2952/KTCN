package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NHANVIEN")
public class NHANVIEN {
    @Id
    private String Ma_NV;
    @NotBlank(message = "Tên là bắt buộc")
    private String Ten_NV;
    private String Phai;
    private String Noi_Sinh;
    @ManyToOne
    @JoinColumn(name = "Ma_Phong")
    private PHONGBAN Ma_Phong;
    private int Luong;
}