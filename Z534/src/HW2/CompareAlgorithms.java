package HW2;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.similarities.BM25Similarity;
import org.apache.lucene.search.similarities.DefaultSimilarity;
import org.apache.lucene.search.similarities.LMDirichletSimilarity;
import org.apache.lucene.search.similarities.LMJelinekMercerSimilarity;
import org.apache.lucene.store.FSDirectory;

public class CompareAlgorithms {

  

    public static void main(String[] args) throws Exception {

        String indexPath = "/Users/yangyang/Desktop/lucene/hw2/index/";
        
        SearchTRECTopics s = new SearchTRECTopics();
        Map<String, Map<Integer, String>> querys = s.getQuerys();
        
        
        for (String field : querys.keySet()) {
            String filename = "";
            if (field == "title") {
                filename = "shortQuery.txt";
            } else {
                filename = "longQuery.txt";
            }

            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("/Users/yangyang/Desktop/lucene/hw2/reports/LMDJelinekMercer" + filename), "utf-8"));

           // writer.write("QueryID       Q       DocID       Rank        Score       RunID\n");
            Map<Integer, String> queryList = querys.get(field);
            
            for (int num : queryList.keySet()) {
                String queryString = queryList.get(num);
                int rank = 1;
                
                IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(indexPath)));

                IndexSearcher searcher = new IndexSearcher(reader);
                Analyzer analyzer = new StandardAnalyzer();
                //searcher.setSimilarity(new BM25Similarity());
                //searcher.setSimilarity(new DefaultSimilarity());
                //searcher.setSimilarity(new LMDirichletSimilarity());                
                searcher.setSimilarity(new LMJelinekMercerSimilarity((float) 0.7));

                QueryParser parser = new QueryParser("TEXT", analyzer);
                Query query = parser.parse(queryString);
                // System.out.println("Searching for: " + query.toString("TEXT"));

                TopDocs results = searcher.search(query, 1000);

                int numTotalHits = results.totalHits;
                // System.out.println(numTotalHits + " total matching documents");

                // Print retrieved results
                ScoreDoc[] hits = results.scoreDocs;

                for (int i = 0; i < hits.length; i++) {
                    Document doc = searcher.doc(hits[i].doc);
                    float score = hits[i].score;
                    String docno =  doc.get("DOCNO");
                    writer.write(num + "        " + "Q0" + "       " + docno + "       " + rank + "        " + score + "      " + "run-5\n");
                    rank++;
                }
                reader.close();
                
                
            }
            writer.close();
        }
    }

}
