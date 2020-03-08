import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSystem {
    private String[] sourceFiles;
    private String[] destinationFiles;

    public FileSystem(String[] sourceFiles, String[] destinationFiles) {
        this.sourceFiles = sourceFiles;
        this.destinationFiles = destinationFiles;
    }

    public void copyFiles() {
        if (sourceFiles.length != destinationFiles.length) {
            return;
        }
        byte[] buf = new byte[1024];
        int length;

        for (int i = 0; i < sourceFiles.length; i++) {
            try (FileInputStream fis = new FileInputStream(sourceFiles[i]);
                 FileOutputStream fos = new FileOutputStream(destinationFiles[i])) {

                do {
                    if ((length = fis.read(buf, 0, buf.length)) > 0) {
                        fos.write(buf, 0, length);
                    }
                } while (length > 0);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
