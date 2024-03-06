package de.nikey;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Öffne das Programm
        Process process = openProgram("C:\\Program Files (x86)\\ROCCAT\\ROCCAT SWARM\\ROCCAT_Swarm.exe");

        // Warte für einige Zeit (z.B. 5 Sekunden)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Schließe das Programm
        closeProgram(process);
    }

    public static Process openProgram(String programPath) {
        try {
            ProcessBuilder builder = new ProcessBuilder(programPath);
            return builder.start();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeProgram(Process process) {
        try {
            if (process != null) {
                process.destroy();
                Runtime.getRuntime().exec("taskkill /f /im " + "cmd.exe");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}