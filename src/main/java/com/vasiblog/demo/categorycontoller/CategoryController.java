package com.vasiblog.demo.categorycontoller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.vasiblog.demo.articleListModel.ArticleList;

@Controller
public class CategoryController {
		
	Collection<ArticleList> listOfArticles = new ArrayList<ArticleList>();
	ArrayList<ArticleList> listOfRecentArticles = new ArrayList<ArticleList>();
	
	@RequestMapping("/category")
	public ModelAndView category(@RequestParam("categoryType") String categoryType) throws IOException {
		ModelAndView categoryOne_model = new ModelAndView();
		listOfArticles.clear();
		listOfRecentArticles.clear();
		String cat = categoryType + "/";
		BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIA5HDVJBCPVEFUZ6F3", "+MH+SuY4/fmq5JvjFvY6+MrN6EdIbZrLdcpYYk9b");
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCreds)).withRegion("us-east-2").build();        
		ListObjectsV2Request req = new ListObjectsV2Request().withBucketName("vasiblog").withPrefix(cat).withDelimiter("^[a-zA-z0-9. ]*$");
		ListObjectsV2Result result;
		result = s3Client.listObjectsV2(req);
		for (S3ObjectSummary objectSummary : result.getObjectSummaries()) {
			ArticleList newArticle = new ArticleList();
			String fullFileName = objectSummary.getKey();			
			if(fullFileName.equals(cat)) {
				continue;
			}
			String fileWithOutExtension = fullFileName.replace(".docx", "").replace(cat, "");
			boolean regEXForFileNAme = fileWithOutExtension.matches("^[a-zA-Z0-9. ]*$");			
			if(regEXForFileNAme){				
				newArticle.setTitleOfArticle(fileWithOutExtension);			
				java.util.Date utilDate = objectSummary.getLastModified();			
				newArticle.setFileDate(new java.sql.Date(utilDate.getTime()));
				listOfArticles.add(newArticle);
				listOfRecentArticles.add(newArticle);
				int n = listOfRecentArticles.size();
				if(n>1) {
					ArticleList key = newArticle;
					int j = listOfRecentArticles.size()-2;
					while(j>=0 && listOfRecentArticles.get(j).getFileDate().before(key.getFileDate())) {
						listOfRecentArticles.set(j+1, listOfRecentArticles.get(j));
						j = j - 1;
					}
					listOfRecentArticles.set(j+1, key);
				}
				
			}			
        }	
		categoryOne_model.addObject("categoryList",listOfArticles);
		categoryOne_model.addObject("categoryType", categoryType);
		categoryOne_model.addObject("recentPostsList",listOfRecentArticles);
		categoryOne_model.setViewName("categoryPage");
		return categoryOne_model;
	}
}
