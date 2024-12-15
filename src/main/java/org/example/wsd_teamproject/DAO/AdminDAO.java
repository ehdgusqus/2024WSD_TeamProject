package org.example.wsd_teamproject.DAO;

import org.apache.ibatis.session.SqlSession;
import org.example.wsd_teamproject.VO.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminDAO {

    @Autowired
    private SqlSession sqlSession;

    public List<AdminVO> getInventoryList() {
        return sqlSession.selectList("AdminMapper.getInventoryList");
    }

    public AdminVO getProductById(int inventory_id) {
        return sqlSession.selectOne("AdminMapper.getProductById", inventory_id);
    }

    public void addProduct(AdminVO product) {
        sqlSession.insert("AdminMapper.addProduct", product);
    }

    public void updateProduct(AdminVO product) {
        sqlSession.update("AdminMapper.updateProduct", product);
    }

    public void deleteProduct(int inventory_id) {
        sqlSession.delete("AdminMapper.deleteProduct", inventory_id);
    }
}
