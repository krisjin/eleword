package net.eleword.blog.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.eleword.blog.search.IndexHolder;
import net.eleword.blog.search.SearchHelper;
import net.eleword.blog.search.entity.LuceneArticle;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-4-23下午2:12:06
 */

public class ArticleTest {

	public static void main(String[] args) throws IOException {
		// IndexHolder index=IndexHolder.init("e:/Post");
		// index.add(getArticles());
		// index.update(getArticles());
		// index.delete(getArticles());

		// List str = SearchHelper.splitKeywords("网dddd络安全在当今互联网中的位置");
		// TermQuery query = (TermQuery) SearchHelper.makeQuery("互联网安全",
		// "互联网安全", 0.3f);
		// IndexSearcher search= new IndexSearcher(null);
		// System.out.println(str);
		// search();
	}

	// @Test
	public void index() throws IOException {
		IndexHolder index = IndexHolder.init("e:/eleword-index");
		index.add(getArticles());
		// index.update(getArticles());
		// index.delete(getArticles());

	}

	@Test
	public void search() throws IOException {
		String[] q = { "title", "content" };

		String filePath = "e:/eleword-index/Article";
		Directory dir = FSDirectory.open(new File(filePath));
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher search = new IndexSearcher(reader);

		// Query query =SearchHelper.makeQuery("content", "网络", 0.3f);

		Query query = SearchHelper.makeMultiQueryFiled(q, "网络", 1.0f);
		TopDocs topDocs = search.search(query, 5);
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		System.out.println("共：" + topDocs.totalHits + "条结果");

		for (ScoreDoc doc : scoreDocs) {
			int docId = doc.doc;
			Document document = search.doc(docId);

			String id = document.get("id");
			String title = document.get("title");
			System.out.println("------------------------------------------------------------------");
			System.out.println("id=" + id + "    title=" + title);
		}

	}

	public List<LuceneArticle> getArticles() {
		List<LuceneArticle> articles = new ArrayList<LuceneArticle>();

		articles.add(new LuceneArticle(1, "网络安全在当今互联网中的位置", "计划2020年开通，从四季青桥始发至东田阳附近，距离项目20分钟车程"));
		articles.add(new LuceneArticle(2, "开启北京自住房万元时代", "紫峰•九院城位于通州于家务次中心CED中央生态区，张凤路与大德路交汇处，总规划约60万㎡，分三期开发。一期近23万平米"));
		articles.add(new LuceneArticle(3, "多维交通 立体路网 一城繁华 触手可及", "项目距离国贸32公里，距通州新城18公里，项目临近京哈"));
		articles.add(new LuceneArticle(4, "郊90空调", "项目距离国贸32公里，距通州新城18公里网络，项目临近京哈"));
		articles.add(new LuceneArticle(5, "公路交通", "项目距离国贸32公里，距通州新城18公里，项目临近京哈"));
		return articles;
	}
}
