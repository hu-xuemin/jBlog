package com.hxz.jblog.domain.article;

import java.util.Date;

public class Article {

	private long id;

	private String owerusername;

	private String title;

	private String articlecontent;

	private Date topTime;

	private Date updateTime;

	private String category;

	private boolean canDiscussStatus = true;
	
	private int articleStatus = 0;

	private Date lastReplyTime;

	private boolean isSort = false;

	public Article() {
	}

	public Article(long id, String owerusername, String title, String articlecontent) {
		this.id = id;
		this.owerusername = owerusername;
		this.title = title;
		this.articlecontent = articlecontent;
		refreshUpdateTime();
		refreshLastReplyTime(new Date(System.currentTimeMillis()));
	}

	public void setArticleInfo(long id, String owerusername, String title, String articlecontent) {
		this.id = id;
		this.owerusername = owerusername;
		this.title = title;
		this.articlecontent = articlecontent;
	}

	private void refreshUpdateTime() {
		this.updateTime = new Date(System.currentTimeMillis());
	}

	private void refreshLastReplyTime(Date date) {
		this.lastReplyTime = date;
	}

	public long getArticleId() {
		return this.id;
	}

	public String getOwerUserName() {
		return this.owerusername;
	}

	public String getArticleContent() {
		// TODO Auto-generated method stub
		return this.articlecontent;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}

	public void edit(String title, String articlecontent) {
		// TODO Auto-generated method stub
		this.title = title;
		this.articlecontent = articlecontent;
		refreshUpdateTime();
	}

	public void top(Date time) {
		// TODO Auto-generated method stub
		this.topTime = time;
	}

	public Date getTop() {
		if (this.topTime != null && this.updateTime != null) {
			if (this.topTime.after(this.updateTime)) {
				return this.topTime;
			} else {
				return this.updateTime;
			}
		} else {
			return this.updateTime;
		}
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void classify(String category) {
		// TODO Auto-generated method stub
		this.category = category;
	}

	public String getCategory() {
		return this.category;
	}

	public boolean canReply() {
		return canDiscussStatus && articleStatus == 0;
	}

	public void closeDiscuss() {
		// TODO Auto-generated method stub
		this.canDiscussStatus = false;
	}

	public void openDiscuss() {
		// TODO Auto-generated method stub
		this.canDiscussStatus = true;
	}

	public void draft() {
		// TODO Auto-generated method stub
		this.articleStatus = 1;
	}

	public void recyle() {
		// TODO Auto-generated method stub
		this.articleStatus = 2;
	}

	public void republish() {
		// TODO Auto-generated method stub
		this.articleStatus = 0;
		refreshUpdateTime();
	}

	private boolean isSort() {
		if (isSort) {
			return isSort;
		}
		isSort = true;
		return isSort;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Date lastReplyTime() {
		return this.lastReplyTime;
	}
}
