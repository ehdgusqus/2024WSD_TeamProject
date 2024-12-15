package org.example.wsd_teamproject.Service;

import org.example.wsd_teamproject.DAO.LoginDAO;
import org.example.wsd_teamproject.VO.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginDAO loginDAO;

    // 로그인 인증
    public LoginVO getLogin(LoginVO vo) {
        return loginDAO.getLogin(vo); // 로그인 정보 반환
    }
}
