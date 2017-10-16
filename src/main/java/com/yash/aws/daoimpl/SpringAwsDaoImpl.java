package com.yash.aws.daoimpl;
import java.io.InputStream;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.yash.aws.dao.SpringAwsDao;

@Component
public class SpringAwsDaoImpl implements SpringAwsDao {
	AmazonS3 client = AmazonS3ClientBuilder.standard()
			.withRegion(Regions.US_EAST_2)
			.build();

	private String bucketName = "svkadiyala";

	@Override
	public void uploadFile(InputStream path, String fileName) {
		PutObjectRequest request = new PutObjectRequest(bucketName, fileName, path, null);
        request.setCannedAcl(CannedAccessControlList.PublicRead);
        client.putObject(request);
	}

	@Override
	public ArrayList<S3ObjectSummary> getObjects() {
		ObjectListing object_listing = client.listObjects("svkadiyala");
		return (ArrayList<S3ObjectSummary>) object_listing.getObjectSummaries();
	}

	@Override
	public void deleteObject(String key) {
		 try{
	            client.deleteObject("svkadiyala", key);
	        } catch(Exception e){
	            System.out.println("Incorrect bucketName or key");
	        }
		
	}
}
