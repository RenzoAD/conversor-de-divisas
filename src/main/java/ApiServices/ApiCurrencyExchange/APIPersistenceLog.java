package ApiServices.ApiCurrencyExchange;

import java.io.*;

public class APIPersistenceLog {

    private static final String pathLog = "./src/main/resources/apiLogs/";

    public File getFile (String fileName){
        File file = new File(pathLog+fileName);
        if (file.exists()) {return file;}
        try (FileWriter fileWriter = new FileWriter(file)) {
            return file;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeLog(String fileName, String body){
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(getFile(fileName),false));
            printWriter.println(body);
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readLog(String fileName){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(getFile(fileName)));
            String read = bufferedReader.readLine();
            StringBuilder textReaded = new StringBuilder();

            while (read!=null){
                textReaded.append(read);
                read = bufferedReader.readLine();
            }
            return textReaded.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
