package lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
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
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.MultiFields;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.Terms;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;

public class generateIndex {

    public static void main(String[] args) {
        String indexPath = "/Users/yangyang/Desktop/lucene/index/index01";
        IndexWriter writer;

        try {
            Directory dir = FSDirectory.open(Paths.get(indexPath));
            Analyzer analyzer = new StandardAnalyzer();
            IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
            iwc.setOpenMode(OpenMode.CREATE);
            writer = new IndexWriter(dir, iwc);

            File f = new File("/Users/yangyang/Desktop/lucene/corpus");
            File[] files = f.listFiles();
            int totalFileNumber = 0;

            for (File file : files) {
                String DOCNO = "";
                String HEAD = "";
                String BYLINE = "";
                String DATELINE = "";
                String TEXT = "";
                String line = "";

                if (file.getName().endsWith(".trectext")) {
                    totalFileNumber++;
                    // System.out.println(file);
                    // read from file
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    while ((line = br.readLine()) != null) {
                        
                    }

                    // Close the input stream
                    br.close();
                    Document luceneDoc = new Document();
                    String fileName = file.getName();

                    luceneDoc.add(new StringField("TITLE", file.getName(), Field.Store.YES));
                    // luceneDoc.add(new StringField("DOCNO", DOCNO,
                    // Field.Store.YES));
                    // luceneDoc.add(new TextField("TEXT", TEXT,
                    // Field.Store.YES));
                    writer.addDocument(luceneDoc);
                }
            }
            System.out.println(totalFileNumber);
            writer.close();

            IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get((indexPath))));
            // Print the total number of documents in the corpus
            System.out.println("Total number of documents in the corpus:" + reader.maxDoc());
            // Print the number of documents containing the term "new"
            // in<field>TEXT</field>.
            System.out.println("Number of documents containing the term \"new\" for field \"TEXT\": "
                    + reader.docFreq(new Term("TEXT", "new")));
            // Print the total number of occurrences of the term "new" across
            // all documents for <field>TEXT</field>.
            System.out.println("Number of occurrences of \"new\" in the field \"TEXT\": "
                    + reader.totalTermFreq(new Term("TEXT", "new")));
            Terms vocabulary = MultiFields.getTerms(reader, "TEXT");
            // Print the size of the vocabulary for <field>TEXT</field>,
            // applicable when the index has only one segment.
            System.out.println("Size of the vocabulary for this field:" + vocabulary.size());
            // Print the total number of documents that have at least one term
            // for<field>TEXT</field>
            System.out.println(
                    "Number of documents that have at least one term for this field: " + vocabulary.getDocCount());
            // Print the total number of tokens for <field>TEXT</field>
            System.out.println("Number of tokens for this field:" + vocabulary.getSumTotalTermFreq());
            // Print the total number of postings for <field>TEXT</field>
            System.out.println("Number of postings for this field:" + vocabulary.getSumDocFreq());
            // Print the vocabulary for <field>TEXT</field>
            TermsEnum iterator = vocabulary.iterator();
            BytesRef byteRef = null;
            System.out.println("\n*******Vocabulary-Start**********");
            while ((byteRef = iterator.next()) != null) {
                String term = byteRef.utf8ToString();
                System.out.print(term + "\t");
            }
            System.out.println("\n*******Vocabulary-End**********");
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
