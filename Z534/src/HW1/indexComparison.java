package HW1;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Paths;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.MultiFields;
import org.apache.lucene.index.Terms;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;

public class indexComparison {
    public static void main(String[] args) throws Exception {
        // KeywordAnalyzer
        String index1 = "/Users/yangyang/Desktop/lucene/index/index01";
        // SimpleAnalyzer
        String index2 = "/Users/yangyang/Desktop/lucene/index/index02";
        // StopAnalyzer
        String index3 = "/Users/yangyang/Desktop/lucene/index/index03";
        // StandardAnalyzer
        String index4 = "/Users/yangyang/Desktop/lucene/index/index04";

        indexComparison cmp = new indexComparison();
        System.out.println("-------------KeywordAnalyzer---------------");
        cmp.stats(index1);
        System.out.println("-------------SimpleAnalyzer----------------");
        cmp.stats(index2);
        System.out.println("-------------StopAnalyzer------------------");
        cmp.stats(index3);
        System.out.println("-------------StandardAnalyzer---------------");
        cmp.stats(index4);

    }

    static void stats(String index) throws Exception {
        IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(index)));

        System.out.println("Total number of documents in the corpus: " + reader.maxDoc());

        Terms vocabulary = MultiFields.getTerms(reader, "TEXT");
        System.out.println("Size of the vocabulary for this field: " + vocabulary.size());

        System.out
                .println("Number of documents that have at least one term for this field: " + vocabulary.getDocCount());

        System.out.println("Number of tokens for this field: " + vocabulary.getSumTotalTermFreq());

        System.out.println("Number of postings for this field: " + vocabulary.getSumDocFreq());

        TermsEnum iterator = vocabulary.iterator();
        BytesRef byteRef = null;

        Writer writer = null;
        String filename = "/Users/yangyang/Desktop/lucene/vocabulary/" + index.substring(index.length() - 1) + ".txt";
        System.out.println("\n*******Vocabulary-Start**********");
        int count = 0;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
            // save the vocabulary to the file
            while ((byteRef = iterator.next()) != null) {
                String term = byteRef.utf8ToString();
                // System.out.println(term);
                writer.write(term + "\n");

                count++;
            }
        } catch (IOException ex) {
            // report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
                /* ignore */}
        }

        System.out.println("\n*******Vocabulary-End**********");
        System.out.println("total terms in the vocabulary: " + count);
        reader.close();
    }
}
