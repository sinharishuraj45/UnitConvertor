package output;

import java.io.*;

public class ConversionHistory {
    public void addConvHistory(String historyData) throws IOException {
        File historyFile = new File("ConversionHistoryFile.txt");
        if (!historyFile.exists())
            historyFile.createNewFile();

        File historyFileCount = new File("ConversionHistoryFileCounter.txt");
        if (!historyFileCount.exists()) {
            FileWriter w = new FileWriter(historyFileCount);
            w.write("0");
            w.close();
        }

        BufferedReader br = new BufferedReader(new FileReader(historyFileCount));
        String line = br.readLine();
        br.close();
        int lastCount = Integer.parseInt(line.trim());
        lastCount++;

        FileWriter update = new FileWriter(historyFileCount);
        update.write(String.valueOf(lastCount));
        update.close();

        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(historyFile, true));
        String data = lastCount + ". " + historyData + "\n";
        out.write(data.getBytes());
        out.close();
    }
}
