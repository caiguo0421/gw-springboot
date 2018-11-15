package cn.ty.gw.controller;

import cn.ty.BaseController;
import cn.ty.common.utils.JsonResult;
import cn.ty.gw.model.MobileUpdate;
import cn.ty.gw.service.MobileUpdateService;
import cn.ty.gw.specification.SimpleSpecificationBuilder;
import cn.ty.gw.specification.SpecificationOperator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/admin/mobileUpdate")
public class MobileUpdateController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(MobileUpdateController.class);

    @Autowired
    private MobileUpdateService updateService;

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "admin/mobileUpdate/index";
    }

    @RequestMapping(value = {"/list"})
    @ResponseBody
    public Page<MobileUpdate> list() {
        SimpleSpecificationBuilder<MobileUpdate> builder = new SimpleSpecificationBuilder<MobileUpdate>();
        String searchText = request.getParameter("searchText");
        if (StringUtils.isNotBlank(searchText)) {
            builder.add("name", SpecificationOperator.Operator.likeAll.name(), searchText);
        }
        Page<MobileUpdate> page = updateService.findAll(builder.generateSpecification(), getPageRequest());
        return page;
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap map) {
        MobileUpdate mobileUpdate = updateService.find(id);
        map.put("MobileUpdate", mobileUpdate);
        return "admin/mobileUpdate/form";
    }

//    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
//    @ResponseBody
//    public JsonResult edit(MobileUpdate update, ModelMap map) {
//        try {
//            updateService.saveOrUpdate(update);
//        } catch (Exception e) {
//            return JsonResult.failure(e.getMessage());
//        }
//        return JsonResult.success();
//    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "admin/mobileUpdate/form";
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id, ModelMap map) {
        try {
            updateService.delete(id);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonResult save(@RequestParam("file") MultipartFile file, MobileUpdate update, ModelMap map) {
        try {
            updateService.saveUpdate(file,update);
//            updateService.saveOrUpdate(update);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }


}
