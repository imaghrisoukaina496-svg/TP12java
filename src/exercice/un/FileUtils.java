package exercice.un;

import java.io.IOException;
import java.nio.file.*;

public class FileUtils {
	
	 // Copier un fichier avec NIO
    public static void copy(String src, String dest) throws IOException {
        Files.copy(Paths.get(src), Paths.get(dest), StandardCopyOption.REPLACE_EXISTING);
    }

    // Supprimer un fichier si existe
    public static void deleteIfExists(String path) throws IOException {
        Files.deleteIfExists(Paths.get(path));
    }

}
