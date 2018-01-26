import java.io.File
import java.nio.file.Path
import java.nio.file.Paths
import groovy.util.GroovyTestSuite
import junit.framework.Test
import junit.textui.TestRunner
import java.nio.file.Paths
import java.util.Random
import java.nio.file.FileSystem

class FileOpsTest extends GroovyTestCase {
    /***
     * Tests the copyFiles method
     */
    void testcopyFiles() {
        String dir = System.getProperty("java.io.tmpdir")
        List<Path> sourceFiles = []

        Path destinationFolder = Paths.get(dir, generateRandomWord(8))
        sourceFiles.add(generateRandomFile(dir))
        sourceFiles.add(generateRandomFile(dir))
        FileOps.copyFiles(sourceFiles,destinationFolder)
    }

    /**
     * Generates a random file in the given directory
     * @param A fully qualified path where the random file will be generated.
     * @return The absolute path to the random file
     */
    static Path generateRandomFile(directory) {

        File file = null
        File d = new File(directory)

        try {
            file = File.createTempFile("temp",".tmp", d)
            file.write "Hello world"
        } catch (Exception e) {
            e.printStackTrace()
        }
        return Paths.get(file.absolutePath)
    }

    /**
     * Generates a random string with the given length
     * @return Returns a random string of a given length
     */
    static String generateRandomWord(length) {
        def pool = ['a'..'z', 'A'..'Z', 0..9, ''-''].flatten() // generating pool

        Random random = new Random(System.currentTimeMillis())
        // the loop should be from 0 to length – 1, then the char length would be length
        def randomChars = (0..length).collect { pool[random.nextInt(pool.size())] }
        def randomString = randomChars.join()
    }

}
