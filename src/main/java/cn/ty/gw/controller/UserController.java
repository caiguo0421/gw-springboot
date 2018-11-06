package cn.ty.gw.controller;


import cn.ty.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController  extends BaseController {
    @RequestMapping(value = { "/admin/login" }, method = RequestMethod.GET)
    public String login() {

        return "admin/login";
    }
    @RequestMapping(value = { "/admin/login" }, method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,ModelMap model) {
        try {
//            Subject subject = SecurityUtils.getSubject();
//            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//            subject.login(token);
            return redirect("/admin/index");
        } catch (Exception e) {
            model.put("message", e.getMessage());
        }
        return "admin/login";
    }

    @RequestMapping(value = { "/admin/logout" }, method = RequestMethod.GET)
    public String logout() {
//        Subject subject = SecurityUtils.getSubject();
//        subject.logout();
        return redirect("admin/login");
    }


    @RequestMapping(value ={"/admin/","/admin/index"})
    public String index(){

        return "admin/index";
    }

    @RequestMapping(value = {"/admin/welcome"})
    public String welcome(){

        return "admin/welcome";
    }
}
