package br.com.atena.commons;

import br.com.atena.commons.utils.S3Utils;
import br.com.atena.exceptions.FileException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class S3Service {
    private Logger LOG = LoggerFactory.getLogger(S3Service.class);

    @Autowired
    private AmazonS3 s3Client;

    @Autowired
    private S3Utils s3;

    public URI uploadFile(MultipartFile multipartFile) {
        try {
            String fileName = multipartFile.getOriginalFilename();
            InputStream is = multipartFile.getInputStream();
            String contentType = multipartFile.getContentType();
            return uploadFile(is, fileName, contentType);
        } catch (IOException e) {
            new FileException("Erro de IO: " + e.getMessage());
        }
        return null;
    }

    public URI uploadFile(InputStream is, String fileName, String contentType) {
        try {
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType(contentType);
            LOG.info("Iniciando upload");
            s3Client.putObject(s3.getBucketName(), fileName, is, meta);
            LOG.info("Upload finalizado");
            return s3Client.getUrl(s3.getBucketName(), fileName).toURI();
        } catch (URISyntaxException e) {
            new FileException("Erro de IO: " + e.getMessage());
        }
        return null;
    }
}
