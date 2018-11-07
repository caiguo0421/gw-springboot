package cn.ty.gw.controller;

import cn.ty.BaseController;
import cn.ty.common.utils.JsonResult;
import cn.ty.gw.model.Users;
import cn.ty.gw.service.UserService;
import cn.ty.gw.specification.SimpleSpecificationBuilder;
import cn.ty.gw.specification.SpecificationOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/admin/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = { "/", "/index" })
    public String index() {
        return "admin/user/index";
    }

    @RequestMapping(value = {"/list"})
    @ResponseBody
    public Page<Users> list() {
        SimpleSpecificationBuilder<Users> builder = new SimpleSpecificationBuilder<Users>();
        String searchText = request.getParameter("searchText");
        if (StringUtils.isNotBlank(searchText)) {
            builder.add("name", SpecificationOperator.Operator.likeAll.name(), searchText);
        }
        Page<Users> page = userService.findAll(builder.generateSpecification(), getPageRequest());
        return page;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap map) {
        Users user = userService.find(id);
        map.put("user", user);
        return "admin/user/form";
    }

    @RequestMapping(value= {"/edit"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Users user, ModelMap map){
        try {
            userService.saveOrUpdate(user);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

}
