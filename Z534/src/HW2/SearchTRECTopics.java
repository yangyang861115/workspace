package HW2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.lucene.queryparser.classic.ParseException;

public class SearchTRECTopics {
    /*
     * replace "&" "/" in the line for query parse
     */
    public String checkLine(String line) {
        if (line.contains("&")) {
            line = line.replaceAll("&", " ");
        }
        if (line.contains("/")) {
            line = line.replaceAll("/", " ");
        }
        return line;
    }

    /*
     * get the querys from file topics.51-100 based on the field "title" and
     * "desc" return a map contains title -> [qid1:s1, qid2:s2, ..], desc ->
     * [qid1:s1, qid2:s2, ..]
     */

    public Map<String, Map<Integer, String>> getQuerys() throws Exception {
        String fields[] = { "title", "desc" };
        Map<String, Map<Integer, String>> querys = new HashMap<String, Map<Integer, String>>();
        for (String field : fields) {
            querys.put(field, new HashMap<Integer, String>());
        }

        String file = "/Users/yangyang/Desktop/lucene/hw2/topics.51-100";
        String line;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String title = "";
        String desc = "";
        int num = 0;
        while ((line = br.readLine()) != null) {

            if (line.startsWith("<num>")) {
                num = Integer.parseInt((line.split(":")[1]).trim());
            }

            if (line.startsWith("<title>")) {
                line = checkLine(line);
                title = "";
                title += line.split(":")[1];
                line = br.readLine();
                while (!line.startsWith("<desc>")) {
                    line = checkLine(line);
                    title += line;
                    line = br.readLine();
                }
                // System.out.println(title);

                desc = "";
                line = br.readLine();
                while (!line.startsWith("<smry>")) {
                    line = checkLine(line);
                    desc += line;
                    line = br.readLine();
                }
                // System.out.println(desc);

                // add to querys
                querys.get("title").put(num, title);
                querys.get("desc").put(num, desc);

            }
        }
        // System.out.println(records);
        return querys;
    }

    public void report(Map<String, Map<Integer, String>> querys) throws IOException, ParseException {
        EasySearch es = new EasySearch();

        for (String field : querys.keySet()) {
            String filename = "";
            if (field == "title") {
                filename = "shortQuery.txt";
            } else {
                filename = "longQuery.txt";
            }

            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("/Users/yangyang/Desktop/lucene/hw2/reports/myAlgorithm" + filename),
                    "utf-8"));

            //writer.write("QueryID       Q      DocID       Rank        Score       RunID\n");
            Map<Integer, String> queryList = querys.get(field);
            for (int num : queryList.keySet()) {
                String query = queryList.get(num);
                String indexPath = "/Users/yangyang/Desktop/lucene/hw2/index";
                Map scores = es.computeScore(query, indexPath);
                /*******************/
                // sort and rank
                Map<Float, ArrayList<String>> topScores = topKScores(1000, scores);
                int rank = 1;
                for (Float s : topScores.keySet()) {
                    for (String docno : topScores.get(s)) {
                        writer.write(num + "        " + "Q0" + "       " + docno + "       " + rank + "        " + s
                                + "      " + "run-1\n");
                        rank++;
                    }
                }

            }
            writer.close();
        }

    }

    /*
     * get the top k scores from an input scores map<String docno, float score>
     */
    public Map<Float, ArrayList<String>> topKScores(int k, Map<String, Float> scores) {
        Map<Float, ArrayList<String>> topScores = new TreeMap<Float, ArrayList<String>>(Collections.reverseOrder());
        for (String key : scores.keySet()) {
            if (topScores.containsKey(scores.get(key))) {
                topScores.get(scores.get(key)).add(key);
            } else {
                topScores.put(scores.get(key), new ArrayList<String>());
                topScores.get(scores.get(key)).add(key);
            }
        }
        Map<Float, ArrayList<String>> topScores2 = new TreeMap<Float, ArrayList<String>>(Collections.reverseOrder());
        int count = 0;
        for (Float key : topScores.keySet()) {
            if (count + topScores.get(key).size() <= k) {
                topScores2.put(key, topScores.get(key));
                count += topScores.get(key).size();
            } else {
                if (count < k) {
                    topScores2.put(key, new ArrayList<String>());
                    for (int i = 0; i < k - count; i++) {
                        topScores2.get(key).add(topScores.get(key).get(i));
                    }
                }

                break;
            }

        }

        return topScores2;
    }

    public static void main(String[] args) throws Exception {

        SearchTRECTopics s = new SearchTRECTopics();
        Map querys = s.getQuerys();
        s.report(querys);
        // System.out.println(querys);
        /*
         * test function topKScores
         * 
         * EasySearch es = new EasySearch(); String indexPath =
         * "/Users/yangyang/Desktop/lucene/hw2/index"; Map scores =
         * es.computeScore("new york", indexPath); Map topScores =
         * s.topKScores(10, scores); for(Object key: topScores.keySet()){
         * System.out.println(key); System.out.println(topScores.get(key)); }
         */
    }

}
