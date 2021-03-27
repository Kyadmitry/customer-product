package app.smart.test_project.security.controller;

import app.smart.test_project.security.model.LoginForm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

@Controller
@ApiIgnore
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage(ModelMap model, HttpServletRequest request) {

        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", true);
        }
        return "login";
    }
}
