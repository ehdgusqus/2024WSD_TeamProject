package org.example.wsd_teamproject.Controller;

import org.example.wsd_teamproject.Service.AdminService;
import org.example.wsd_teamproject.VO.AdminVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public String showInventoryList(Model model) {
        List<AdminVO> inventoryList = adminService.getInventoryList();
        model.addAttribute("products", inventoryList);
        return "admin/adminInventory"; // 제품 목록 페이지
    }

    @GetMapping("/add")
    public String showAddProductForm() {
        return "admin/addAdmin"; // 제품 추가 페이지
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute AdminVO product, Model model) {
        System.out.println("Product Name: " + product.getProduct_name());
        System.out.println("Quantity: " + product.getQuantity());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Category: " + product.getCategory());

        if (product.getProduct_name() == null || product.getProduct_name().trim().isEmpty()) {
            model.addAttribute("errorMessage", "Product name cannot be empty.");
            return "error";
        }

        adminService.addProduct(product);
        return "redirect:/admin";
    }



    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") int inventory_id, Model model) {
        AdminVO product = adminService.getProductById(inventory_id);
        model.addAttribute("product", product);
        return "admin/editAdmin"; // 제품 수정 페이지
    }

    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable("id") int inventory_id, @ModelAttribute AdminVO product) {
        product.setInventory_id(inventory_id);
        adminService.updateProduct(product);
        return "redirect:/admin"; // 제품 목록 페이지로 리다이렉트
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int inventory_id) {
        adminService.deleteProduct(inventory_id);
        return "redirect:/admin"; // 제품 목록 페이지로 리다이렉트
    }
}
