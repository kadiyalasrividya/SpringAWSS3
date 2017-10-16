package com.yash.aws.dao;

import java.io.InputStream;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.amazonaws.services.s3.model.S3ObjectSummary;

@Repository
public interface SpringAwsDao {
	
	public void uploadFile(InputStream path, String fileName);
	public ArrayList<S3ObjectSummary> getObjects();
	public void deleteObject(String key);
}
