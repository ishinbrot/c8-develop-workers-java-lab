package com.camunda.academy.handler;

import java.io.InputStream;

import com.camunda.academy.services.SQLService;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.client.api.worker.JobHandler;

public class PictureInDatabaseHandler implements JobHandler {

	@Override
	public void handle(JobClient client, ActivatedJob job) throws Exception {

		System.out.println("(" + job.getKey()+ ") Handling job: " + job.getType());
		SQLService sqlService = new SQLService();

		try {
			String imageUrl = String.valueOf(job.getVariable("picture"));
			InputStream inputStream = sqlService.downloadImage(imageUrl);

			System.out.println("Uploading to database");
		//	sqlService.storeImageInDatabase(inputStream);


		} catch (Exception e) {
		}


	}

	
}
