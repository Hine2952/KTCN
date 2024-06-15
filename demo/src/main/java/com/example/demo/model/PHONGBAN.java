package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PHONGBAN")
public class PHONGBAN {
    @Id
    private String Ma_Phong;
    @NotBlank(message = "Tên là bắt buộc")
    private String Ten_Phong;
}
