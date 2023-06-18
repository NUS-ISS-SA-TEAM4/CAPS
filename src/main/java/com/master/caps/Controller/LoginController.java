package com.master.caps.Controller;

import com.master.caps.Algorithm.Password;
import com.master.caps.Model.LoginParam;
import com.master.caps.service.PersonService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {
    @Autowired
    private PersonService personService;

    @GetMapping("/login")
    public String toLogin(Model model) {
        model.addAttribute("loginParam", new LoginParam());
        return "login";
    }

    /**
     * @roleType the role type user chose from login page
     * @username the username user enter in login page
     * @password the password user enter in login page
     * @personService.login() return boolean
     *                        use roleType, username, password user entering to retrieve a specific person
     *                        if person is null, return false
     *                        otherwise return true
     * @Author susie
     */
    @PostMapping("/login")
    public String login(Model model,
                        HttpSession session,
                        @Valid @ModelAttribute("loginParam") LoginParam loginParam,
                        BindingResult bindingResult) throws Exception {

        // encrypt password user entered in, then using encrypted password to retrieve person obj
        String SecretPassword = Password.encrypt(loginParam.getPassword());
        Integer roleType = loginParam.getRoleType();
        String username = loginParam.getUsername();
        String returnPage = "login";

        if (bindingResult.hasErrors()) {
            return returnPage;
        }

        // for roleType, 0 means student, 1 means lecturer, 2 means admin
        if (roleType != 0 && roleType != 1 && roleType != 2){
            return returnPage;
        }
        // call method to retrieve and check person data in DB
        if(!personService.login(roleType, username, SecretPassword)) {
            model.addAttribute("loginErrorMessage",
                    "Incorrect user ID or password");
            return returnPage;
        }
        if(roleType == 0) {
            returnPage = "redirect:/student";
        }
        if(roleType == 1) {
            returnPage = "redirect:lecturer";
        }
        if(roleType == 2) {
            returnPage = "redirect:admin";
        }

        session.setAttribute("username", loginParam.getUsername());
        model.addAttribute("loginParam", loginParam);

        return returnPage;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
}
