package Level5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class B10 {
    public static void processTemplate(String fileInput, String fileOutput, Map<String,String> params) throws IOException{
        // đọc nội dung file template
        String content = new String (Files.readAllBytes(Paths.get(fileInput)));

        // thay thế
        for(Map.Entry<String, String> entry : params.entrySet()){
            String regex = "\\{\\{" + entry.getKey() +"\\}\\}";
            content = content.replaceAll(regex, Matcher.quoteReplacement(entry.getValue()));
        }

        //ghi file
        Files.write(Paths.get(fileOutput), content.getBytes());

    }

    public static void main(String[] args) {
        try {
            String inputFile = "src/Level5/input1.txt"; 
            String outputFile = "src/Level5/output1.txt"; 

            Map<String, String> params = new HashMap<>();
            params.put("name", "Jonny");

            processTemplate(inputFile, outputFile, params);
            System.out.println("File processed successfully: " + outputFile);


            String inputFileHtml = "src/Level5/input2.html"; 
            String outputFileHtml = "src/Level5/output2.html"; 

            Map<String, String> paramsHtml = new HashMap<>();
            paramsHtml.put("title", "Search of skill");
            paramsHtml.put("pageTitle", "Home page");
            paramsHtml.put("content", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab, consectetur");

            processTemplate(inputFileHtml, outputFileHtml, paramsHtml);
            System.out.println("File processed successfully: " + outputFileHtml);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
