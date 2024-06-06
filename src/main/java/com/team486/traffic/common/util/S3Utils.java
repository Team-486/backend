//package com.team486.traffic.common.util;
//
//import com.amazonaws.services.s3.AmazonS3;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//@Component
//@RequiredArgsConstructor
//public class S3Utils {
//    private final AmazonS3 s3Client;
//
//    @Value("${amazon.s3.bucket.name}")
//    private String bucketName;
//
//    private boolean isNullOrEmpty(final MultipartFile file) {
//        return file == null || file.isEmpty();
//    }
//}
