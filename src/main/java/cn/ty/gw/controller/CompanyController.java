package cn.ty.gw.controller;

import cn.ty.BaseController;
import cn.ty.common.utils.JsonResult;
import cn.ty.gw.model.CompanyUrlMapping;
import cn.ty.gw.service.CompanyService;
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
@RequestMapping("/admin/company")
public class CompanyController extends BaseController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = { "/", "/index" })
    public String index() {
        return "admin/company/index";
    }

    @RequestMapping(value = {"/list"})
    @ResponseBody
    public Page<CompanyUrlMapping> list() {
        SimpleSpecificationBuilder<CompanyUrlMapping> builder = new SimpleSpecificationBuilder<CompanyUrlMapping>();
        String searchText = request.getParameter("searchText");
        if (StringUtils.isNotBlank(searchText)) {
            builder.add("name", SpecificationOperator.Operator.likeAll.name(), searchText);
        }
        Page<CompanyUrlMapping> page = companyService.findAll(builder.generateSpecification(), getPageRequest());
        return page;
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap map) {
        CompanyUrlMapping company = companyService.find(id);
        map.put("company", company);
        return "admin/company/form";
    }

    @RequestMapping(value= {"/edit"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(CompanyUrlMapping company, ModelMap map){
        try {
            companyService.saveOrUpdate(company);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "admin/company/form";
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id,ModelMap map) {
        try {
            companyService.delete(id);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }
}
