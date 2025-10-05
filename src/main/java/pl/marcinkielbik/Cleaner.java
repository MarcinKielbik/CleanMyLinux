package pl.marcinkielbik;

import java.io.File;

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

}
