package org.example.wsd_teamproject.DAO;

import org.apache.ibatis.session.SqlSession;
import org.checkerframework.checker.units.qual.A;
import org.example.wsd_teamproject.VO.LoginVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {
    @Autowired
    SqlSessionTemplate sqlSession;
    public LoginVO getLogin(LoginVO vo){
        return sqlSession.selectOne("Login.getLogin",vo);
    }
}
