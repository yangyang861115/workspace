package HW1;
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.MultiFields;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.Terms;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Index all text files under a directory.
 * <p>
 * This is a command-line application demonstrating simple Lucene indexing. Run
 * it with no command-line arguments for usage information.
 */
public class generateIndex {

    private generateIndex() {
    }

    /** Index all text files under a directory. */
    public static void main(String[] args) {
        String filePath = "/Users/yangyang/Desktop/lucene/corpus";
        File folder = new File(filePath);
        File[] files = folder.listFiles();

        String[] fields = { "DOCNO", "HEAD", "BYLINE", "DATELINE", "TEXT" };
        ArrayList<HashMap<String, String>> documents = new ArrayList<HashMap<String, String>>();
        int num = 0;

        for (File file : files) {
            // read each file
            BufferedReader br = null;
            String line;

            try {
                br = new BufferedReader(new FileReader(file));
                String xmlRecords = "";
                while ((line = br.readLine()) != null) {
                    // change "&" to "&amp" to avoid bug in parse XML
                    if (line.contains("&")) {
                        line = line.replaceAll("&", "&amp;");
                    }

                    if (line.startsWith("<DOC>")) {
                        xmlRecords = line;
                       
                    } else if (line.startsWith("</DOC>")) {
                        xmlRecords += line;
                        // use ReadXMLFile.java to parse the XMLfile string
                        num += 1;
                        ReadXMLFile r = new ReadXMLFile();
                        HashMap<String, String> document = r.parse(xmlRecords, fields);
                        // System.out.println(document.toString());
                        documents.add(document);

                    } else {
                        xmlRecords += line +  " ";
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        System.out.println(num);

        String[] indexPaths = {"/Users/yangyang/Desktop/lucene/index/index01", 
                "/Users/yangyang/Desktop/lucene/index/index02",
                "/Users/yangyang/Desktop/lucene/index/index03",
                "/Users/yangyang/Desktop/lucene/index/index04",
        };
        for(String indexPath : indexPaths) {
            try {
                System.out.println("Indexing to directory '" + indexPath + "'...");

                Directory dir = FSDirectory.open(Paths.get(indexPath));
                Analyzer analyzer = null;
                if(indexPath.endsWith("1")){
                    analyzer = new KeywordAnalyzer();
                }else if(indexPath.endsWith("2")){
                    analyzer = new SimpleAnalyzer();
                }else if(indexPath.endsWith("3")){
                    analyzer = new StopAnalyzer();
                }else if(indexPath.endsWith("4")){
                    analyzer = new StandardAnalyzer();
                } 

                IndexWriterConfig iwc = new IndexWriterConfig(analyzer);

                iwc.setOpenMode(OpenMode.CREATE);

                IndexWriter writer = new IndexWriter(dir, iwc);

                for (HashMap<String, String> doc : documents) {
                    indexDoc(writer, doc);
                }

                writer.close();
            } catch (IOException e) {
                System.out.println(" caught a " + e.getClass() + "\n with message: " + e.getMessage());
            } 
        }
            
    }

    /**
     * Indexes a single document
     * 
     * @throws IOException
     */
    static void indexDoc(IndexWriter writer, HashMap<String, String> document) throws IOException {
        // make a new, empty document
        Document lDoc = new Document();

        lDoc.add(new StringField("DOCNO", document.get("DOCNO"), Field.Store.YES));
        lDoc.add(new TextField("HEAD", document.get("HEAD"), Field.Store.YES));
        lDoc.add(new TextField("BYLINE", document.get("BYLINE"), Field.Store.YES));
        lDoc.add(new TextField("DATELINE", document.get("DATELINE"), Field.Store.YES));
        lDoc.add(new TextField("TEXT", document.get("TEXT"), Field.Store.YES));
        writer.addDocument(lDoc);
    }

}
