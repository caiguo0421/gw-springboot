package cn.ty.gw.service;

import cn.ty.gw.model.ReportSendLog;
import cn.ty.gw.repository.ReportSendLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ReportSendLogService {

    @Autowired
    private ReportSendLogRepository reportSendLogRepository;

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 删除send_log
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteSendLog() {
        List<ReportSendLog> logList = reportSendLogRepository.findBySendDate(formatter.format(new Date()));
        if (logList == null || logList.size() == 0) {
            return;
        }
        reportSendLogRepository.deleteAll(logList);
    }


    /**
     * 在新事物中运行
     *
     * @param subjectNo
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addSuccessSendLog(String subjectNo) {
        ReportSendLog log = new ReportSendLog();
        log.setSendId(UUID.randomUUID().toString());
        log.setSubjectNo(subjectNo);
        log.setSendStatus((short) 1);
        log.setSendDate(formatter.format(new Date()));
        log.setCreateTime(new Timestamp(System.currentTimeMillis()));

        reportSendLogRepository.save(log);
    }



}
