package com.example.demo.controller;

import com.example.demo.model.NHANVIEN;
import com.example.demo.service.NHANVIENService;
import com.example.demo.service.PHONGBANService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/nhanviens")
public class NHANVIENController {
    @Autowired
    private NHANVIENService nhanvienService;
    @Autowired
    private PHONGBANService PhongBanService;
    @GetMapping("/nhanviens")
    public String showProductList(Model model) {
        model.addAttribute("nhanviens", nhanvienService.getAllNhanviens());
        return "/nhanviens/nhanvien-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("nhanvien", new NHANVIEN());
        model.addAttribute("categories", PhongBanService.getAllPhongBan());
        return "/products/add-nhanvien";
    }
    // Process the form for adding a new product
    @PostMapping("/add")
    public String addProduct(@Valid NHANVIEN nhanvien, BindingResult result) {
        if (result.hasErrors()) {
            return "/products/add-nhanvien";
        }
        nhanvienService.addNhanvien(nhanvien);
        return "redirect:/nhanviens/nhanviens";
    }
    // For editing a product
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        NHANVIEN nhanvien = nhanvienService.getNhanVienById(id)
                .orElseThrow(() -> new RuntimeException("NhanVien not found"));
        model.addAttribute("nhanvien", nhanvien);
        return "nhanviens/edit";
    }
    // Process the form for updating a product
    @PostMapping("/update/{id}")
    public String updateNhanVien(@PathVariable String id, @ModelAttribute("nhanvien") NHANVIEN nhanVienDetails) {
        nhanvienService.updateNhanvien(id, nhanVienDetails);
        return "redirect:/nhanviens";
    }
    @GetMapping("/delete/{id}")
    public String deleteNhanvien(@PathVariable String id) {
        nhanvienService.deleteNhanvienById(id);
        return "redirect:/nhanviens/nhanviens";
    }
}
