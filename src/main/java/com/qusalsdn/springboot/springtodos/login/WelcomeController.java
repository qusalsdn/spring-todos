package com.qusalsdn.springboot.springtodos.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name") // 세션을 이용하면 다른 페이지로 넘어가도 값을 유지할 수 있다.
public class LoginController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model) {
        model.put("name", "qusalsdn");
        return "welcome";
    }
}
