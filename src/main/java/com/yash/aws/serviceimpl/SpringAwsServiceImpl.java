package com.yash.aws.serviceimpl;

import java.io.InputStream;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.yash.aws.dao.SpringAwsDao;
import com.yash.aws.service.SpringAwsService;

@Component
public class SpringAwsServiceImpl implements SpringAwsService {

	@Autowired
	SpringAwsDao springAwsDao;

	@Override
	public void uploadFile(InputStream stream, String fileName) {
		springAwsDao.uploadFile(stream, fileName);
	}

	@Override
	public ArrayList<S3ObjectSummary> getObjects() {
		return springAwsDao.getObjects();
	}

	@Override
	public void deleteObject(String key) {
		springAwsDao.deleteObject(key);	
	}

}
