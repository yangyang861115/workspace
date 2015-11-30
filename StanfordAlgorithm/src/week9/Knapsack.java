package week9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    public static int knapsack(int knapsack_size, int number_of_items, List<Item> list) {
        int A[][] = new int[number_of_items + 1][knapsack_size + 1];
        for (int x = 0; x <= knapsack_size; x++) {
            A[0][x] = 0;
        }
        for (int i = 1; i <= number_of_items; i++) {
            for (int x = 0; x <= knapsack_size; x++) {
                int weight_i = list.get(i - 1).weight;
                int value_i = list.get(i - 1).value;
                if (x >= weight_i)
                    A[i][x] = max(A[i - 1][x], A[i - 1][x - weight_i] + value_i);
                else
                    A[i][x] = A[i - 1][x];
            }
        }

        return A[number_of_items][knapsack_size];
    }

    private static int max(int i, int j) {
        if (i >= j)
            return i;
        else
            return j;

    }

    public static void main(String[] args) {
        int knapsack_size = 0;
        int number_of_items = 0;
        List<Item> list = new ArrayList<Item>();
        FileInputStream fstream = null;
        BufferedReader br = null;
        String strLine;
        try {
            // Open the file
            fstream = new FileInputStream("src/week9/knapsack1.txt");
            br = new BufferedReader(new InputStreamReader(fstream));
            try {
                strLine = br.readLine();
                String[] record = strLine.split(" ");
                knapsack_size = Integer.parseInt(record[0]);
                number_of_items = Integer.parseInt(record[1]);

                while ((strLine = br.readLine()) != null) {
                    record = strLine.split(" ");
                    int value = Integer.parseInt(record[0]);
                    int weight = Integer.parseInt(record[1]);
                    list.add(new Item(value, weight));
                }
                // Close the input stream
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(knapsack_size + " " + number_of_items);
        System.out.println(knapsack(knapsack_size, number_of_items, list));
    }

}

class Item {
    int value;
    int weight;

    public Item(int v, int w) {
        value = v;
        weight = w;
    }

    public String toString() {
        return "[" + value + " " + weight + "]";
    }
}