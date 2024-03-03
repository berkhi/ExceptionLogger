package com.berkhayta;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LogServices {
    public void kaydet(Log log) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("loglar.bin", true))) {
            writer.write(log.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Log dosyasına yazma sırasında bir hata oluştu!");
            e.printStackTrace();
        }
    }

    public List<Log> loglariOku() {
        List<Log> loglar = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("loglar.bin"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] logBilgileri = line.split(", ");
                if (logBilgileri.length == 6) {
                    String errorMessage = logBilgileri[0];
                    int errorCode = Integer.parseInt(logBilgileri[1].split("=")[1]);
                    String className = logBilgileri[2];
                    String methodName = logBilgileri[3];
                    LocalDateTime zaman = LocalDateTime.parse(logBilgileri[4].split("=")[1]);
                    String detay = logBilgileri[5];
                    loglar.add(new Log(errorMessage, errorCode, className, methodName, zaman ,detay));
                }
            }
        } catch (IOException e) {
            System.out.println("Log dosyasını okuma sırasında bir hata oluştu!"+ e.getMessage());
            e.printStackTrace();
        }

        return loglar;
    }
}
