import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

public class FixPunctuation {

	public static void main(String[] args) throws IOException {

		String text = "";

		Scanner in = new Scanner(System.in);

		System.out.println("Please enter the input file ");
		String inputFile = in.next();
		System.out.println("Please enter output file");
		String outputFile = in.next();

		File input = new File(inputFile);
		BufferedReader br = new BufferedReader(new FileReader(input));
		String sCurrentLine;

		if (input.exists()) {

			while ((sCurrentLine = br.readLine()) != null) {

				text = text + sCurrentLine + "\n";
			}

			JOptionPane.showMessageDialog(null, text, "Input File", JOptionPane.INFORMATION_MESSAGE);
			text = text.replaceAll("\\s+", " ").trim();
			int pos = 0;
			boolean capitalize = true;
			StringBuilder sb = new StringBuilder(text);

			while (pos < sb.length()) {

				if (sb.charAt(pos) == '.' || sb.charAt(pos) == '?' || sb.charAt(pos) == '!') {

					capitalize = true;

				} else if (capitalize && !Character.isWhitespace(sb.charAt(pos))) {

					sb.setCharAt(pos, Character.toUpperCase(sb.charAt(pos)));
					capitalize = false;

				}

				pos++;
			}

			FileWriter writer = new FileWriter(outputFile);
			writer.write(sb.toString());
			writer.close();
			br.close();

			JOptionPane.showMessageDialog(null, sb.toString(), "Output File", JOptionPane.INFORMATION_MESSAGE);

		} else {

			JOptionPane.showMessageDialog(null, "File name does not exist. Try Again.");
		}
	}

}