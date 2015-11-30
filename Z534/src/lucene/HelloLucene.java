package lucene;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

public class HelloLucene {
    public void index() {
        IndexWriter writer = null;
        try {
            // 1.创建Directory
            // Directory directory = new RAMDirectory(); //内存中
            // 硬盘上
            Directory directory = FSDirectory.open(Paths.get("/Users/yangyang/Desktop/lucene/index/index01"));

            // 2.创建IndexWriter
            Analyzer analyzer = new StandardAnalyzer();
            IndexWriterConfig iwc = new IndexWriterConfig(analyzer);

            writer = new IndexWriter(directory, iwc);
            // 3.创建Document对象
            Document doc = null;
            // 4.为Document添加Field
            File f = new File("/Users/yangyang/Desktop/lucene/file");
            for (File file : f.listFiles()) {
                doc = new Document();
                doc.add(new StringField("filename", file.getName(), Field.Store.YES));
                doc.add(new TextField("text", new FileReader(file)));

                // 5.通过IndexWriter添加文档到索引中
                writer.addDocument(doc);
            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

    // 搜索
    public void searcher() {

        try {
            // 1. 创建Directory
            Directory directory = FSDirectory.open(Paths.get("/Users/yangyang/Desktop/lucene/index/index01"));
            // 2. 创建IndexReader
            IndexReader reader = DirectoryReader.open(directory);
            System.out.println("Total number of documents in the corpus: " + reader.maxDoc());
            
            // 3. 根据IndexReader创建IndexSearcher
            IndexSearcher searcher = new IndexSearcher(reader);
            // 4. 创建搜索的Query
            QueryParser parser = new QueryParser("filename", new StandardAnalyzer());
            Query query = null;
            try {
                query = parser.parse("hj");
              //搜索内容包含
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            // 5. 根据searcher搜索并且返回TopDocs
            TopDocs tds = searcher.search(query, 10);
            // 6. 根据TopDocs获取ScoreDoc对象
            ScoreDoc[] sds = tds.scoreDocs;
            for(ScoreDoc sd : sds){
             // 7. 根据searcher和ScoreDoc对象获取具体的Document对象
                Document d = searcher.doc(sd.doc);
                // 8. 根据Document对象获取需要的值
                 System.out.println(d.get("text"));
            }
            
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
