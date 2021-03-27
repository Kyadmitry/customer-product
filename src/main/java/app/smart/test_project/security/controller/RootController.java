package app.smart.test_project.security.controller;

import app.smart.test_project.security.details.UserDetailsImpl;
import app.smart.test_project.security.model.UserDto;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

import static app.smart.test_project.security.model.UserDto.from;

@Controller
@ApiIgnore
public class RootController {

    @GetMapping("/")
    public String getProfilePage(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl)authentication.getPrincipal();
        UserDto user = from(details.getUser());
        model.addAttribute("user", user);
        return "profile";

    }
}
