package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        JSONReport reportJson = new JSONReport();
        String text = reportJson.generate("Report's name", "Report's body");
        System.out.println(text);
    }
}