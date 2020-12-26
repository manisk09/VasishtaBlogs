package com.vasiblog.demo.articlecontroller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Controller
public class ArticleController {
		
	@RequestMapping("/articleSelected")
	public ModelAndView article(@RequestParam("articleTitle") String articleTitle, @RequestParam("categoryType") String categoryType) {
		ModelAndView article_model = new ModelAndView();
		System.out.println(categoryType);
		String key  = categoryType + "/" + articleTitle + ".docx" ;		
		List<XWPFParagraph> paraList = null;
		List<XWPFPictureData> pic = null;
		ArrayList<String> imagesInFile = new ArrayList<String>();
		try {
			System.out.println(articleTitle);
			BasicAWSCredentials awsCreds = new BasicAWSCredentials("******", "******");
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCreds)).withRegion("us-east-2").build();
			S3Object object = s3Client.getObject(new GetObjectRequest("vasiblog", key));
			InputStream objectData = object.getObjectContent();
			//String pathToFile = "H:\\UNH\\VasiBlogs\\"+articleTitle+".docx";
			//FileInputStream fis = new FileInputStream(objectData);
			XWPFDocument docx = new XWPFDocument(objectData); 		    
			
			String baseHtml = "";
			Document doc = Jsoup.parse(baseHtml);
			
			String imagePath = null;
			String base64Image = null;
			pic = docx.getAllPictures();
			Iterator<XWPFPictureData> iterator = pic.iterator(); 
			while(iterator.hasNext()) {
				XWPFPictureData pic1 = iterator.next(); 
				byte[] bytepic = pic1.getData(); 			  
				base64Image = Base64.getEncoder().encodeToString(bytepic); 
				imagesInFile.add(base64Image);
			}			
			
			paraList = docx.getParagraphs();			
			//System.out.println(paraList.size());
			int imageCount = 0;
			String a = new String();
			for(int i=0;i<paraList.size();i++) {
				a = paraList.get(i).getText();
				if(a.isEmpty()) {					
					imagePath = "data:image/jpg;base64,"+ imagesInFile.get(imageCount);
					doc.body().appendElement("img").attr("src", imagePath).attr("class", "img-fluid").attr("width","100").attr("height","70");					
					imageCount++;
				}
				if(i == 0) {
					article_model.addObject("articleTitle", a);
					doc.body().appendElement("br");
				} else {
					doc.body().appendElement("a").appendText(a).addClass("articleText");
					doc.body().appendElement("br");	
				}				
			}
			
			docx.close();						
			article_model.addObject("articleText", doc.toString());
			article_model.setViewName("articlePage");
			return article_model;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(
	            mapper);
	    return converter;
	}
	
}
