package cn.ty.gw.controller;

import cn.ty.BaseController;
import cn.ty.common.utils.JsonResult;
import cn.ty.gw.model.ReportSubject;
import cn.ty.gw.model.Users;
import cn.ty.gw.service.ReportSubjectService;
import cn.ty.gw.specification.SimpleSpecificationBuilder;
import cn.ty.gw.specification.SpecificationOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/subject")
public class SubjectController extends BaseController {
    @Autowired
    private ReportSubjectService subjectService;

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "admin/subject/index";
    }

    @RequestMapping(value = {"/list"})
    @ResponseBody
    public Page<ReportSubject> list() {
        SimpleSpecificationBuilder<ReportSubject> builder = new SimpleSpecificationBuilder<ReportSubject>();
        String searchText = request.getParameter("searchText");
        if (StringUtils.isNotBlank(searchText)) {
            builder.add("name", SpecificationOperator.Operator.likeAll.name(), searchText);
        }
        PageRequest pageRequest = getPageRequest();
        if (pageRequest.getSort() == Sort.unsorted()) { //默认按sortNo排序
            pageRequest = getPageRequest(new Sort(Sort.Direction.ASC, "sortNo"));
        }

        Page<ReportSubject> page = subjectService.findAll(builder.generateSpecification(), pageRequest);
        return page;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable String id, ModelMap map) {
        ReportSubject subject = subjectService.find(id);
        map.put("subject", subject);
        return "admin/subject/form";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(ReportSubject subject, ModelMap map) {
        try {
            subjectService.saveOrUpdate(subject);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "admin/subject/form";
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable String id, ModelMap map) {
        try {
            subjectService.delete(id);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }
}
