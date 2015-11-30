package cs61b.src.hw1;
import java.io.*;
class Nuke2 {
	public static void main(String[] arg) throws Exception{
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String words = keyboard.readLine();
		String newwords = "";
		for(int i = 0; i < words.length(); i++){
			if(i != 1)
				newwords += words.charAt(i);
		}
		System.out.println(newwords);
	}
}
