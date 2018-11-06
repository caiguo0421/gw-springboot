package cn.ty.gw.service;

import cn.ty.gw.model.ReportSubject;
import cn.ty.gw.repository.ReportSubjectRepository;
import cn.ty.common.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
}
