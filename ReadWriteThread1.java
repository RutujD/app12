package app12.com.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteThread1 implements Runnable {
	private String readFile;
    private String writeFile;

    public ReadWriteThread1(String readFile, String writeFile) {
        this.readFile = readFile;
        this.writeFile = writeFile;
    }
    
    @Override
    public void run() {
        String additionalWork = "作業内容：新しいプログラムを開発しました。";
        String timeTaken = "2時間"; // 作業に要した時間

        try {
            FileReader fileReader = new FileReader(readFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(writeFile, true); // true for append mode
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // 読み込んだ内容を新しいファイルに書き込む
                bufferedWriter.write(line + "\n");

                // "本日の作業内容：" の下に自身の作業内容を追加
                if (line.contains("本日の作業内容：")) {
                    bufferedWriter.write(additionalWork + "\n");
                }

               
                if (line.contains("作業時間：")) {
                    bufferedWriter.write("作業時間：" + timeTaken + "\n");
                }
            }

            fileReader.close();
            bufferedReader.close();
            bufferedWriter.close();
            System.out.println("*ファイルに書き込みました。");

        } catch (IOException e) {
            System.err.println("エラー: " + e.getMessage());
        }
}
}
