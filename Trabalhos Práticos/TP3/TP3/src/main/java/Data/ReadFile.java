package Data;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ReadFile {

    public List<String> loadDataFromFile(String fileName) {
        List<String> fileData = new ArrayList<>();
        try {
            fileData = Files.lines(Paths.get(fileName), Charset.forName("Cp1252")).collect(Collectors.toList());
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        fileData.remove(0);
        return fileData;
    }

}
