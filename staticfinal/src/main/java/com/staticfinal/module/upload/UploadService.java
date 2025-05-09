package com.staticfinal.module.upload;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class UploadService {
	
	@Autowired
	UploadDao dao;
	@Value("${cloud_aws_bucket}")
	private String bucket;
	
	public void uploadFilesToS3(MultipartFile file,MultipartFile[] multipartFiles, UploadDto dto, String tableName, String pSeq,
			AmazonS3Client amazonS3Client) throws Exception {
		
		if(!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
			String uuid = UUID.randomUUID().toString();
			String uuidFileName = uuid + "." + ext;
			String pathModule = tableName;
			String path = pathModule + "/";

			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(file.getSize());
			metadata.setContentType(file.getContentType());

			amazonS3Client.putObject(bucket, path + uuidFileName, file.getInputStream(), metadata);

			String objectUrl = amazonS3Client.getUrl(bucket, path + uuidFileName).toString();

			dto.setPath(objectUrl);
			dto.setOriginalName(fileName);
			dto.setUuidName(uuidFileName);
			dto.setExt(ext);
			dto.setSize(file.getSize());

			dto.setTableName(tableName);
			dto.setpSeq(pSeq);

			dao.insertUploaded(dto);
		}

		for (int i = 0; i < multipartFiles.length; i++) {

			if (!multipartFiles[i].isEmpty()) {

				String fileName = multipartFiles[i].getOriginalFilename();
				String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
				String uuid = UUID.randomUUID().toString();
				String uuidFileName = uuid + "." + ext;
				String pathModule = tableName;
				String path = pathModule + "/";

				ObjectMetadata metadata = new ObjectMetadata();
				metadata.setContentLength(multipartFiles[i].getSize());
				metadata.setContentType(multipartFiles[i].getContentType());

				amazonS3Client.putObject(bucket, path + uuidFileName, multipartFiles[i].getInputStream(), metadata);

				String objectUrl = amazonS3Client.getUrl(bucket, path + uuidFileName).toString();

				dto.setPath(objectUrl);
				dto.setOriginalName(fileName);
				dto.setUuidName(uuidFileName);
				dto.setExt(ext);
				dto.setSize(multipartFiles[i].getSize());

				dto.setTableName(tableName);
				dto.setpSeq(pSeq);

				dao.insertUploaded(dto);
			}
		}
	}

}
