package com.vasiblog.demo.articleListModel;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ArticleList")
public class ArticleList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int articleId;
	private String titleOfArticle;
	private Date fileDate;
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getTitleOfArticle() {
		return titleOfArticle;
	}
	public void setTitleOfArticle(String titleOfArticle) {
		this.titleOfArticle = titleOfArticle;
	}
	public Date getFileDate() {
		return fileDate;
	}
	public void setFileDate(Date fileDate) {
		this.fileDate = fileDate;
	}
	@Override
	public String toString() {
		return "ArticleList [articleId=" + articleId + ", titleOfArticle=" + titleOfArticle + ", fileDate=" + fileDate
				+ "]";
	}
		
}
