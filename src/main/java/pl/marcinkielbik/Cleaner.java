package pl.marcinkielbik;

import java.io.File;
import java.text.DecimalFormat;

public class Cleaner {

    protected long cleanDirectory(String path) {
        File dir = new File(path);

        if(!dir.exists()) {
            System.out.println(path + "don't exist.");
            return 0;
        }

        long freed = deleteRecursively(dir);
        return freed;
    }

    private long deleteRecursively(File file) {
      long size = 0;

      if (file.isDirectory()) {
          File[] files = file.listFiles();
          if (files != null) {
              for (File f : files) {
                  size += deleteRecursively(f);
              }
          }
      }

      size += file.length();
      if (file.delete()) {
          return size;
      } else {
          return 0;
      }

    }

    protected String readableFileSize(long size) {
        if (size == 0) {
            return "0.0 B";
        }

        final String[] units = {"B", "KB", "MB", "GB", "TB"};

        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

}
