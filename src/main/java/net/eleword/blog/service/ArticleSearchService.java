package net.eleword.blog.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.eleword.blog.dao.ArticleSearchDao;
import net.eleword.blog.search.SearchHelper;
import net.eleword.blog.search.entity.Articles;
import net.eleword.blog.util.Pagination;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 */
@Service
public class ArticleSearchService {

	@Autowired
	private ArticleSearchDao aritcleSearchDao;

	public Pagination<Articles> getAritlce(Pagination<Articles> page) {

		return aritcleSearchDao.selectArticleIndexWithPage(page);

	}

	public List<Articles> search(String keyword, int pageSize, int currentPage) throws IOException {
		if (keyword.equals("") || keyword == null) {
			return null;
		}

		List<Articles> list = new ArrayList<Articles>();

		String[] q = { "title", "content" };

		String filePath = "e:/elewordIndex/Articles";
		Directory dir = FSDirectory.open(new File(filePath));
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher search = new IndexSearcher(reader);

		Query query = SearchHelper.makeMultiQueryFiled(q, keyword, 1.0f);
		TopDocs topDocs = search.search(query, 100);
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;

		int start = pageSize * (currentPage - 1);
		int end = Math.min(start + pageSize, scoreDocs.length);

		for (int i = start; i < end; i++) {
			int docId = scoreDocs[i].doc;
			Document doc = search.doc(docId);

			list.add(new Articles(Long.valueOf(doc.get("id")), doc.get("title"), doc.get("content")));
		}

		return list;

	}

}
