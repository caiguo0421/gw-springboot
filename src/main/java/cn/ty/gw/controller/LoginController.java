package cn.ty.gw.controller;


import cn.ty.BaseController;
import cn.ty.gw.model.Users;
import cn.ty.gw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/admin/login"}, method = RequestMethod.GET)
    public String login() {

        return "admin/login";
    }


    @RequestMapping(value = {"/admin/login"}, method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, ModelMap model) {
        try {
            Users user = userService.login(username, password);
            model.put("user", user);
            return redirect("/admin/index");
        } catch (Exception e) {
            model.put("message", e.getMessage());
        }
        return "admin/login";
    }

    @RequestMapping(value = {"/admin/logout"}, method = RequestMethod.GET)
    public String logout() {
        return redirect("admin/login");
    }


    @RequestMapping(value = {"/admin/", "/admin/index"})
    public String index() {
        return "admin/index";
    }

    @RequestMapping(value = {"/admin/welcome"})
    public String welcome() {

        return "admin/welcome";
    }
}
