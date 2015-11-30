package HW2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.MultiFields;
import org.apache.lucene.index.PostingsEnum;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.similarities.DefaultSimilarity;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;

public class EasySearch {
   
    /*
     * computeScore
     * compute the score for an input query (queryString)
     * from the index path (indexPath)
     * return a map contains <docno, score>
     * all the scores for each term and query can be saved in files
     */
    public Map<String, Float> computeScore(String queryString, String indexPath) throws IOException, ParseException {

        IndexReader reader = DirectoryReader
                .open(FSDirectory.open(Paths.get(indexPath)));
        IndexSearcher searcher = new IndexSearcher(reader);

        // Total number of documents in the corpus
        int N = reader.maxDoc();
        //System.out.println("Total number of documents in the corpus " + N);
        //System.out.println("-----------------------------------");
        
        Map<String, Float> scores = new TreeMap<String, Float>();
        // Get query terms from the query string
        // Get the preprocessed query terms
        Analyzer analyzer = new StandardAnalyzer();
        QueryParser parser = new QueryParser("TEXT", analyzer);
        Query query = parser.parse(queryString);

        Set<Term> queryTerms = new LinkedHashSet<Term>();
        searcher.createNormalizedWeight(query, false).extractTerms(queryTerms);

        // System.out.println("Terms in the query: ");
        for (Term t : queryTerms) {
            String filename = "/Users/yangyang/Desktop/lucene/hw2/scores/" + t.text() + ".txt";
//            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
//
//            writer.write("term    docno     score\n");

            //System.out.println("Term = " + t.text());
            // Get document frequency df
            int df = reader.docFreq(new Term("TEXT", t.text()));
//           System.out.println(df);
//            System.out.println(
//                    "Number of documents containing the term \"" + t.text() + "\" for field \"TEXT\"(df): " + df);
//            System.out.println("Writing to file: term  doc score....");
            float idf = (float) Math.log(1 + 1.0 * N / df);
            System.out.println("idf = " + idf);
            DefaultSimilarity dSimi = new DefaultSimilarity();
            // Get the segments of the index
            List<LeafReaderContext> leafContexts = reader.getContext().reader().leaves();
            // Processing each segment
            
            for (int i = 0; i < leafContexts.size(); i++) {
                // Get document length
                LeafReaderContext leafContext = leafContexts.get(i);
                int startDocNo = leafContext.docBase;
                // int numberOfDoc = leafContext.reader().maxDoc();

                // Get frequency of the term from its postings
                PostingsEnum de = MultiFields.getTermDocsEnum(leafContext.reader(), "TEXT", new BytesRef(t.text()));
                int doc;
                if (de != null) {
                    while ((doc = de.nextDoc()) != PostingsEnum.NO_MORE_DOCS) {
//                         System.out.println("\"" + t.text() + "\" occurs "
//                         + de.freq() + " time(s) in doc(" + (de.docID() + startDocNo) + ")");

                        // Get normalized length (1/sqrt(numOfTokens)) of the ￼document
                        float normDocLeng = dSimi
                                .decodeNormValue(leafContext.reader().getNormValues("TEXT").get(de.docID()));
                        // Get length of the document
                        float docLeng = 1 / (normDocLeng * normDocLeng);
//                         System.out.println("Length of doc(" + (de.docID()
//                         + startDocNo) + ", " + searcher.doc(de.docID() +
//                         startDocNo).get("DOCNO") + ") is " + docLeng);
//                        
                        float score = de.freq() / docLeng * idf;
                        // System.out.println("\"" + t.text() + "\" occurs " + de.freq() + " time(s) in doc("
                        // + (de.docID() + startDocNo) + ", length of the
                        // doc is "+ docLeng + ", score for this term in this doc is "+ score+ ")");
                        // System.out.println(t.text()+" "+ (de.docID() + startDocNo) +" " + score);
                        int docNo = de.docID() + startDocNo;
                        String docno = searcher.doc(docNo).get("DOCNO");
                        //writer.write(t.text() + "        " + docno + "         " + score + "\n");
                        if (!scores.containsKey(docno)) {
                            scores.put(docno, score);
                        } else {
                            scores.put(docno, scores.get(docno) + score);
                        }
                    }
                }
            }
            

//            writer.close();

        }
        // compute the score for query and each document
//        System.out.println("Computing the query score ...");
//        System.out.println("Writing the score to queryscore.txt");

      //write the score for doc and query to the  file
//        Writer writer = new BufferedWriter(new OutputStreamWriter(
//                new FileOutputStream("/Users/yangyang/Desktop/lucene/hw2/scores/queryscore.txt"), "utf-8"));
//        
//        writer.write("docno     score\n");
//        for (Entry<String, float> entry : scores.entrySet()) {
//            writer.write(entry.getKey() + "        " + entry.getValue() + "\n");
//        }
//        writer.close();

        return scores;
    }

    public static void main(String[] args) throws IOException, ParseException {
        String query = "York";
        String indexPath = "/Users/yangyang/Desktop/lucene/hw2/index";
        EasySearch es = new EasySearch();
        Map scores = es.computeScore(query, indexPath);
        //System.out.println(scores);
    }
}
