package com.oxentepass.oxentepass.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Config {

    @Bean
    public S3Client s3Client() {
        Dotenv dotenv = Dotenv.load();

        return S3Client.builder()
            .region(Region.of(dotenv.get("AWS_REGION")))
            .credentialsProvider(
                StaticCredentialsProvider.create(
                    AwsBasicCredentials.create(
                        dotenv.get("AWS_ACCESS_KEY_ID"),
                        dotenv.get("AWS_SECRET_ACCESS_KEY")
                    )
                )
            )
            .build();
    }
}
