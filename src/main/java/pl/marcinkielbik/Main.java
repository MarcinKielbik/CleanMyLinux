package pl.marcinkielbik;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cleaner cleaner = new Cleaner();

        String home = System.getProperty("user.home");
        String trash = home + "/.local/share/Trash/files";

        System.out.println("=== Clean My Linux ===");

        long freed = 0;

        freed += cleaner.cleanDirectory(trash);

        System.out.println("Total freed space: " + cleaner.readableFileSize(freed));
        System.out.println("Done ✅");
    }
}