package yelp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/*
 * generate index for training file
 */
public class generateTrainingIndex {
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        String indexPath = "/Users/yangyang/Desktop/lucene_index/trainingIndexFilePath";
        System.out.println("Indexing to directory '" + indexPath + "'...");
        Directory dir = FSDirectory.open(Paths.get(indexPath));
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        iwc.setOpenMode(OpenMode.CREATE);
        IndexWriter writer = new IndexWriter(dir, iwc);
        int count = 0;
        
        String filePath = "/Users/yangyang/Desktop/lucene_index/categories";
        File folder = new File(filePath);
        File[] files = folder.listFiles();
        for (File file : files) {
            // read each file
            BufferedReader br = new BufferedReader(new FileReader(file));
            String category = br.readLine();
            StringBuilder reviewAndTips = new StringBuilder();
            String line = "";
            while ((line = br.readLine()) != null) {
                reviewAndTips.append(line);
            }
            
            Document lDoc = new Document();
            lDoc.add(new StringField("category", category , Field.Store.YES));
            lDoc.add(new TextField("reviewAndTips", reviewAndTips.toString(), Field.Store.YES));
            writer.addDocument(lDoc);
            System.out.println(count);
            count++;
        }
        writer.close();
        System.out.println("Finishing indexing " + (count -1 ) + " documents...");
    }
}
