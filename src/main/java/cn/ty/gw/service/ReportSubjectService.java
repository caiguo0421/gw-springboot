package cn.ty.gw.service;

import cn.ty.gw.model.ReportSubject;
import cn.ty.gw.model.Users;
import cn.ty.gw.repository.ReportSubjectRepository;
import cn.ty.common.ServiceException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ReportSubjectService {
    private Logger logger = LoggerFactory.getLogger(ReportSubjectService.class);

    @Autowired
    private ReportSubjectRepository reportSubjectRepository;

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


    public List<String> getFailSubjectNo() {
        return reportSubjectRepository.findFailSubjectNo(formatter.format(new Date()));
    }

    public void saveSql(String subjectId, String filePath) {
        ReportSubject subject = reportSubjectRepository.findById(subjectId).get();
        subject.setReportSql(getFileContent(filePath));
        reportSubjectRepository.save(subject);
    }


    public String getFileContent(String filePath) {

        File file = new File(filePath);
        //读取文件内容
        BufferedReader bReader = null;
        StringBuilder sb = new StringBuilder();
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "GBK");
//            InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
            bReader = new BufferedReader(isr);

            String tmp = "";
            while ((tmp = bReader.readLine()) != null) {
                sb.append(tmp + "\n");
            }
        } catch (Exception ex) {
            throw new ServiceException("读取文件" + file.getAbsolutePath() + "出错", ex);
        } finally {
            try {
                bReader.close();
            } catch (Exception e1) {
                //do nothing
            }
        }
//        logger.info(String.format("reportType:%s serverVersion:%s  sql:\r\n %s", reportType, urlMapping.getServerVersion(), sb.toString()));
        return sb.toString();
    }

    public Page<ReportSubject> findAll(Specification<ReportSubject> spec, PageRequest pageRequest) {
        return reportSubjectRepository.findAll(spec, pageRequest);
    }

    public ReportSubject find(String id) {
        return reportSubjectRepository.getOne(id);
    }


    public void saveOrUpdate(ReportSubject subject) {
        if (StringUtils.isBlank(subject.getSubjectId())) {

            subject.setReportStatus((short) 1);
            subject.setCreateTime(new Timestamp(System.currentTimeMillis()));
            if (subject.getSortNo() == null) {
                subject.setSortNo((short) (getMaxSortNo() + 1));
            }

            reportSubjectRepository.save(subject);
        } else {
            ReportSubject formSubject = find(subject.getSubjectId());

            formSubject.setSubjectNo(subject.getSubjectNo());
            formSubject.setSubjectName(subject.getSubjectName());
            formSubject.setReportVersion(subject.getReportVersion());
            formSubject.setReportSql(subject.getReportSql());
            formSubject.setReportRemark(subject.getReportRemark());
            formSubject.setSortNo(subject.getSortNo());

            if (formSubject.getSortNo() == null) {
                formSubject.setSortNo((short) (getMaxSortNo() + 1));
            }
            reportSubjectRepository.saveAndFlush(formSubject);
        }
    }


    private short getMaxSortNo() {
        short maxSortNo = 0;
        List<Short> maxSortNoList = reportSubjectRepository.findMaxSortNo();
        if (maxSortNoList != null && maxSortNoList.size() > 0) {
            maxSortNo = maxSortNoList.get(0) == null ? 0 : maxSortNoList.get(0);
        }
        return maxSortNo;
    }

    public void delete(String id) {
        ReportSubject subject = find(id);
        if (subject == null) {
            throw new ServiceException(String.format("报表（%d）不存在", id));
        }
        reportSubjectRepository.delete(subject);
    }
}
