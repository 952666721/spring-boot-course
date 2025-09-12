package top.qqs.boot.config.service.impl;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.qqs.boot.config.config.OssConfig;
import top.qqs.boot.config.service.OssService;

import java.io.InputStream;
import java.util.UUID;

@Slf4j
@Service
public class OssServiceImpl implements OssService {
    @Resource
    private OssConfig ossConfig;
    @Override
    public String upload(MultipartFile file) {
        if (file != null){
            String originalFilename=file.getOriginalFilename();
            assert  originalFilename != null;
            String suffix=originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName= UUID.randomUUID()+suffix;
            log.info("新文件名: {}", newFileName);
            String endpoint=ossConfig.getEndpoint();
            String bucketName=ossConfig.getBucketName();
            String accessKey=ossConfig.getAccessKey();
            String secretKey=ossConfig.getSecretKey();
            String dir=ossConfig.getDir();

            OSS ossClient=new OSSClientBuilder().build(endpoint,accessKey,secretKey);
            ObjectMetadata meta=new ObjectMetadata();
            meta.setContentType("image/jpg");
            String uploadPath=dir+newFileName;
            InputStream inputStream;
            try {
                inputStream=file.getInputStream();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            ossClient.putObject(bucketName, uploadPath, inputStream,meta);
            ossClient.shutdown();
            return "http://"+bucketName+"."+endpoint+"/"+uploadPath;
        }
        return "上传失败";
    }
}
