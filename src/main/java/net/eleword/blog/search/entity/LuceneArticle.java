package net.eleword.blog.search.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import net.eleword.blog.search.Searchable;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-4-22下午1:50:32
 */

public class LuceneArticle  implements Searchable {

	private long id;

	private String title;

	private String content;

	public LuceneArticle() {
	}

	public LuceneArticle(long id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public int compareTo(Searchable o) {

		return 0;
	}

	public long id() {

		return id;
	}

	public List<String> storeFields() {

		return Arrays.asList("id", "title");
	}

	public List<String> indexFields() {

		return Arrays.asList("title", "content");
	}

	public float boost() {

		return 0;
	}

	public Map<String, String> extendStoreDatas() {

		return null;
	}

	public Map<String, String> extendIndexDatas() {

		return null;
	}

	public List<? extends Searchable> ListAfter(long id, int count) {

		return null;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
