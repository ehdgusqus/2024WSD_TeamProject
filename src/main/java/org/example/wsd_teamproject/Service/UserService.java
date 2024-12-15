package org.example.wsd_teamproject.Service;

import org.example.wsd_teamproject.DAO.UserDAO;
import org.example.wsd_teamproject.VO.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // 관리자 상품 목록 조회
    public List<UserVO> getAdminInventory() {
        return userDAO.getAdminInventory(); // UserDAO에서 관리자 상품 목록 조회
    }

    // 사용자 장바구니 추가
    public void addToCart(UserVO userProduct) {
        userDAO.addToCart(userProduct.getInventoryId(), userProduct.getQuantity()); // DAO 호출해서 장바구니에 추가
    }

    // 사용자 장바구니 조회
    public List<UserVO> getUserCart() {
        return userDAO.getUserCart(); // 장바구니 목록 조회
    }

    // 사용자 장바구니 삭제
    public void removeFromCart(int userInventoryId) {
        userDAO.removeFromCart(userInventoryId); // 장바구니에서 삭제
    }

    // 사용자 장바구니 수정
    public void updateCartItem(int userInventoryId, int quantity) {
        userDAO.updateCartItem(userInventoryId, quantity); // 장바구니 수정
    }
}
