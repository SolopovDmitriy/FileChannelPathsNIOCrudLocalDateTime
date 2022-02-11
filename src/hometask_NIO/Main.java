package hometask_NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Path d1 = Paths.get("D:\\javaProject\\NIO_Project", "tst");
        System.out.println(d1);
        Files.createDirectories(d1); // Используя Files, создайте папку tst.
        Path tmpFile = d1.resolve("tmp.txt");
        System.out.println(tmpFile);

        // В параметрах try-with-resource создайте канал, используя FileChannel:
        try (Scanner scanner = new Scanner(System.in); // ввод с клавиатуры в консоль
             // создаем файл,  открываем канал для доступа к файлу
             FileChannel channel = FileChannel.open(tmpFile, StandardOpenOption.CREATE,
                     StandardOpenOption.WRITE, StandardOpenOption.DELETE_ON_CLOSE)
        ) {
            while (!scanner.hasNext("/")){
                String line = scanner.nextLine() + "\n";
                byte [] inputBytes = line.getBytes();
                ByteBuffer buffer = ByteBuffer.wrap(inputBytes);
                channel.write(buffer); // записываем из буфера в tmpFile
            }
            // LocalDateTime.now() - дата создания файла; Files.readString(tmpFile) - чтение текста из файла - tmpFile (tmp.txt)
            String str = LocalDateTime.now() + "\n" + Files.readString(tmpFile) + "\n";
            Path main = d1.resolve("main.txt"); // создание пути для главного файла
            Files.writeString(main, str, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
