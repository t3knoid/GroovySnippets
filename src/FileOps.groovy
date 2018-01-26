import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class FileOps {
    /***
     * Copies a given list of files to a specified path
      * @param files is a list fully qualified file paths
     * @param folder is a path to copy to
     */
    static void copyFiles(List<Path> files, Path folder) {
        Path destFile

        // Create destination folder if it doesn't exists
        File destFolder = new File(folder.toString())
        if (!destFolder.exists() ) {
            destFolder.mkdirs()
        }
        try {
            files.each { srcFile ->
                destFile = Paths.get(destFolder.toString(),srcFile.getFileName().toString())
                Files.copy(srcFile, destFile) // https://docs.oracle.com/javase/7/docs/api/java/nio/file/Files.html
            }
        } catch (Exception e) {
            e.printStackTrace()
        }
    }

    static void main(String[] args) {
    }
}
