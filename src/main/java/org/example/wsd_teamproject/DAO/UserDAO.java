package org.example.wsd_teamproject.DAO;

import org.apache.ibatis.session.SqlSession;
import org.example.wsd_teamproject.VO.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDAO {

    @Autowired
    private SqlSession sqlSession;

    // 관리자 상품 목록 조회
    public List<UserVO> getAdminInventory() {
        return sqlSession.selectList("UserMapper.getAdminInventory");
    }

    // 사용자 장바구니 추가
    public void addToCart(int inventoryId, int quantity) {
        Map<String, Object> params = new HashMap<>();
        params.put("inventoryId", inventoryId);
        params.put("quantity", quantity);
        sqlSession.insert("UserMapper.addToCart", params); // 사용자 장바구니에 추가
    }

    // 사용자 장바구니 조회
    public List<UserVO> getUserCart() {
        return sqlSession.selectList("UserMapper.getUserCart");
    }

    // 사용자 장바구니 삭제
    public void removeFromCart(int userInventoryId) {
        sqlSession.delete("UserMapper.removeFromCart", userInventoryId);
    }

    // 사용자 장바구니 수정
    public void updateCartItem(int userInventoryId, int quantity) {
        Map<String, Object> params = new HashMap<>();
        params.put("userInventoryId", userInventoryId);
        params.put("quantity", quantity);
        sqlSession.update("UserMapper.updateCartItem", params);
    }
}
