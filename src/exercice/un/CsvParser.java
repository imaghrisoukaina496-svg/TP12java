package exercice.un;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvParser {
	
	public static List<Record> readCsv(String path) throws IOException {
        Path p = Paths.get(path);

        try (Stream<String> lines = Files.lines(p)) {
            return lines
                    .skip(1) // saute l'en-tête id,name,score
                    .filter(l -> !l.trim().isEmpty())
                    .map(CsvParser::parseLine)
                    .collect(Collectors.toList());
        }
    }

	private static Record parseLine(String line) {
	    // split sur virgule OU tabulation ; le + veut dire "une ou plusieurs"
	    String[] parts = line.split("[,\t]+");

	    int id = Integer.parseInt(parts[0].trim());
	    String name = parts[1].trim();
	    double score = Double.parseDouble(parts[2].trim());

	    return new Record(id, name, score);
	}

    // Écriture List<Record> -> CSV
    public static void writeCsv(List<Record> records, String path) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(path))) {
            bw.write("id,name,score");
            bw.newLine();

            for (Record r : records) {
                bw.write(r.getId() + "," + r.getName() + "," + r.getScore());
                bw.newLine();
            }
        }
    }

}
