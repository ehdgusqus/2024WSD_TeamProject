package org.example.wsd_teamproject.Controller;

import org.example.wsd_teamproject.Service.LoginService;
import org.example.wsd_teamproject.VO.LoginVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final LoginService loginService;

    // 생성자 주입
    public UserController(LoginService loginService) {
        this.loginService = loginService;
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("role") String role, Model model) {
        try {
            LoginVO loginVO = new LoginVO();
            loginVO.setUsername(username);
            loginVO.setPassword(password);
            loginVO.setRole(role);

            LoginVO authenticatedUser = loginService.getLogin(loginVO); // 로그인 인증

            if (authenticatedUser != null) {
                model.addAttribute("user", authenticatedUser); // 로그인 성공 시 사용자 정보 추가

                if ("admin".equals(authenticatedUser.getRole())) {
                    return "redirect:/admin/dashboard"; // 관리자로 로그인한 경우 대시보드로 리다이렉트
                } else {
                    return "redirect:/users/dashboard"; // 유저로 로그인한 경우 대시보드로 리다이렉트
                }
            } else {
                model.addAttribute("errorMessage", "Invalid username or password.");
                return "login"; // 로그인 실패 시 로그인 페이지로 리다이렉트
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error during login.");
            return "login"; // 에러가 발생한 경우 로그인 페이지로 리다이렉트
        }
    }

    // 로그아웃 처리
    @GetMapping("/logout")
    public String logout(Model model) {
        // 세션을 무효화하여 로그아웃 처리
        model.addAttribute("message", "You have been logged out.");
        return "redirect:/users/login"; // 로그아웃 후 로그인 페이지로 리다이렉트
    }
}
