package br.com.atena.commons.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class S3Utils {
    @Value("${aws.access_key_id}")
    private String awsId;

    @Value("${aws.secret_access_key}")
    private String awsKey;

    @Value("${s3.region}")
    private String region;

    @Value("${s3.bucket}")
    private String bucketName;

    @Value("${img.profile.size}")
    private int tamanhoImagem;

    @Value("${img.profile.format}")
    private String formatoImagem;
}

