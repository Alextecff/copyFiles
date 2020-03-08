import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file;
        String[] source = {"src/1.txt","src/2.txt"};
        String[] destination = new String[source.length];

        for (int i = 0; i < source.length; i++){
            file = new File(source[i]);
            destination[i] = file.getParent() +"/" + "copy " + file.getName();
        }

        FileSystem fs = new FileSystem(source, destination);
        fs.copyFiles();

    }
}
