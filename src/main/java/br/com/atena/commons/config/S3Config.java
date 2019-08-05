package br.com.atena.commons.config;

import br.com.atena.commons.utils.S3Utils;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {
    @Autowired
    private S3Utils s3;

    @Bean
    public AmazonS3 s3client() {
        BasicAWSCredentials awsCred = new BasicAWSCredentials(s3.getAwsId(), s3.getAwsKey());
        AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion(Regions.fromName(s3.getRegion()))
                .withCredentials(new AWSStaticCredentialsProvider(awsCred)).build();
        return s3client;
    }
}