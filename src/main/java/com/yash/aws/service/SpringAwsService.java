package com.yash.aws.service;

import java.io.InputStream;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.model.S3ObjectSummary;

@Service
public interface SpringAwsService {
	
	public void uploadFile(InputStream path, String fileName);
	public ArrayList<S3ObjectSummary> getObjects();
	public void deleteObject(String key);

}
