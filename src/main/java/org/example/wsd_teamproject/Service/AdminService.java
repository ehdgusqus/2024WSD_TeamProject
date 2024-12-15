package org.example.wsd_teamproject.Service;

import org.example.wsd_teamproject.DAO.AdminDAO;
import org.example.wsd_teamproject.VO.AdminVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminDAO adminDAO;

    public AdminService(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public List<AdminVO> getInventoryList() {
        return adminDAO.getInventoryList();
    }

    public AdminVO getProductById(int inventory_id) {
        return adminDAO.getProductById(inventory_id);
    }

    public void addProduct(AdminVO product) {
        if (product.getProduct_name() == null || product.getProduct_name().trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        adminDAO.addProduct(product);
    }


    public void updateProduct(AdminVO product) {
        adminDAO.updateProduct(product);
    }

    public void deleteProduct(int inventory_id) {
        adminDAO.deleteProduct(inventory_id);
    }

}
