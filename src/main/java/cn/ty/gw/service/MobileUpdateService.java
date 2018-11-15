package cn.ty.gw.service;

import cn.ty.common.ServiceException;
import cn.ty.gw.model.CompanyUrlMapping;
import cn.ty.gw.model.MobileUpdate;
import cn.ty.gw.model.ReportSubject;
import cn.ty.gw.repository.MobileUpdateRepository;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class MobileUpdateService {

    @Autowired
    private MobileUpdateRepository mobileUpdateRepository;

    public Page<MobileUpdate> findAll(Specification<MobileUpdate> spec, PageRequest pageRequest) {
        return mobileUpdateRepository.findAll(spec, pageRequest);
    }

    public MobileUpdate find(Integer id) {
        return mobileUpdateRepository.getOne(id);
    }

    public void saveOrUpdate(MobileUpdate update) {
        if (update.getId() == null) {
            update.setUpdateTime(new Timestamp(System.currentTimeMillis()));

            mobileUpdateRepository.save(update);
        } else {
            MobileUpdate formUpdate = find(update.getId());
            formUpdate.setCompanyNo(update.getCompanyNo());
            formUpdate.setCompanyName(update.getCompanyName());
            formUpdate.setTerminalType(update.getTerminalType());
            formUpdate.setVersionCode(update.getVersionCode());
            formUpdate.setVersionName(update.getVersionName());
            formUpdate.setUpdateContent(update.getUpdateContent());

            mobileUpdateRepository.saveAndFlush(formUpdate);
        }
    }


    public void saveUpdate(MultipartFile file, MobileUpdate update) throws IOException {
        if (file.isEmpty()) {
            throw new ServiceException("文件为空");
        }
        String androidPath = ResourceUtils.getFile("classpath:static").getAbsolutePath() + "/upload/android";
        File targetFile = uploadFile(file, androidPath);
        update.setUpdateTime(new Timestamp(System.currentTimeMillis()));

        mobileUpdateRepository.save(update);
    }


    private File uploadFile(MultipartFile file, String filePath) throws IOException {
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String prifixName = fileName.substring(0, fileName.lastIndexOf("."));
        // 文件上传路径
        File dest = new File(String.format("%s/%s_%s%s", filePath, prifixName, new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), suffixName));
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        file.transferTo(dest);
        return dest;
    }

    public void delete(Integer id) {
        MobileUpdate update = find(id);
        if (update == null) {
            throw new ServiceException(String.format("安装包信息（%d）不存在", id));
        }
        mobileUpdateRepository.delete(update);
    }


    public static void main(String[] args) {
        String fileName = "123.abc";
        System.out.println(fileName.substring(0, fileName.lastIndexOf(".")));
    }


}
