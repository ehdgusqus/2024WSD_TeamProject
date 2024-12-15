package org.example.wsd_teamproject.Controller;

import org.example.wsd_teamproject.Service.UserService;
import org.example.wsd_teamproject.VO.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // 생성자 주입
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 사용자 전용 상품 목록 조회
    @GetMapping
    public String showUserProducts(Model model) {
        List<UserVO> products = userService.getAdminInventory(); // 관리자가 등록한 상품 조회
        model.addAttribute("products", products);
        return "user/userInventory"; // 사용자 상품 목록 페이지
    }

    // 사용자 장바구니 추가
    @PostMapping("/add")
    public String addToCart(@RequestParam("inventoryId") int inventoryId,
                            @RequestParam("quantity") int quantity, Model model) {
        try {
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than 0.");
            }

            UserVO userProduct = new UserVO();
            userProduct.setInventoryId(inventoryId);
            userProduct.setQuantity(quantity);
            userService.addToCart(userProduct); // UserService에 장바구니 추가 요청

            return "redirect:/users/cart"; // 성공 시 장바구니 페이지로 리다이렉트
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error"; // 에러 페이지
        }
    }

    // 사용자 장바구니 조회
    @GetMapping("/cart")
    public String showCart(Model model) {
        try {
            List<UserVO> cartItems = userService.getUserCart();
            model.addAttribute("cartItems", cartItems);
            return "user/userCart"; // 장바구니 페이지
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Failed to load cart items.");
            return "error"; // 에러 페이지
        }
    }

    // 사용자 장바구니 수정
    @PostMapping("/edit")
    public String editCartItem(@RequestParam("userInventoryId") int userInventoryId,
                               @RequestParam("quantity") int quantity, Model model) {
        try {
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than 0.");
            }
            userService.updateCartItem(userInventoryId, quantity);
            return "redirect:/users/cart"; // 수정 후 장바구니로 리다이렉트
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Failed to update cart item.");
            return "error"; // 에러 페이지
        }
    }

    // 사용자 장바구니 삭제
    @PostMapping("/delete")
    public String removeFromCart(@RequestParam("userInventoryId") int userInventoryId, Model model) {
        try {
            userService.removeFromCart(userInventoryId);
            return "redirect:/users/cart"; // 삭제 후 장바구니로 리다이렉트
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Failed to remove item from cart.");
            return "error"; // 에러 페이지
        }
    }
}
