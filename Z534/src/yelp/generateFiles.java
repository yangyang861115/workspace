package yelp;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
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

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/*
 * for each category generate a document 
 * which contains all the reviews and tips
 */
public class generateFiles {

    public static void main(String[] args) throws IOException {
        // connect to the database and get the collection test_set
        MongoClient mongoClient = new MongoClient();
        DB db = mongoClient.getDB("yelp");
        DBCollection collections = db.getCollection("training_collection");

        List<String> categories = (List<String>) collections.distinct("categories");
        // for(String category : categories){
        // System.out.println(category);
        // }
        //get all the categories
        categories.removeAll(Collections.singleton(null));
        DBObject training_query = new BasicDBObject();
        training_query.put("_id", 0);
        training_query.put("reviews", 1);
        training_query.put("tips", 1);
        categories.removeAll(Collections.singleton(null));

        for (String category : categories) {
            category = category.replace("/", " ").replace("&", "");
            //each category(reviews + tips from different business_id) will be saved in a file
            String filename = "/Users/yangyang/Desktop/lucene_index/categories/" + category + ".txt";
            Writer filewriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
           
            DBObject categoriesQuery = new BasicDBObject("categories", category);
            DBCursor cursor = collections.find(categoriesQuery, training_query);
            System.out.println("cursor");
           
            filewriter.write(category + "\n");
            while (cursor.hasNext()) {
                String reviewAndTips = "";
                DBObject bu = cursor.next();
                BasicDBList reviews = (BasicDBList) bu.get("reviews");
                BasicDBList tips = (BasicDBList) bu.get("tips");

                for (Object r : reviews) {
                    reviewAndTips += r.toString() + " ";
                }
                for (Object r : tips) {
                    reviewAndTips += r.toString() + " ";
                }
                filewriter.write(reviewAndTips);
            } // while
            filewriter.close();
        }
    }
}
