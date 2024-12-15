package org.example.wsd_teamproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index"; // /WEB-INF/views/index.jsp로 매핑
    }
}
