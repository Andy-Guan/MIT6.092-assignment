import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MagicSquares {
    public static boolean testMagic(String pathName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathName))) {
            boolean isMagic = true;
            int lastSum = -1;

            String line;
            while ((line = reader.readLine()) != null) {
                // 先 trim 掉前后空白，如果是空行就跳过
                String trimmedLine = line.trim();
                if (trimmedLine.isEmpty()) {
                    continue;
                }

                String[] parts = trimmedLine.split("\t");
                int sum = 0;
                for (String part : parts) {
                    // 对每个部分也 trim，避免 "  123  " 这种情况
                    String numStr = part.trim();
                    if (!numStr.isEmpty()) { // 只对非空字符串尝试解析
                        sum += Integer.parseInt(numStr);
                    }
                }

                if (lastSum == -1) {
                    lastSum = sum;
                } else if (lastSum != sum) {
                    isMagic = false;
                    break;
                }
            }
            return isMagic;
        }
    }
    public static void main(String[] args) throws IOException {
        String[] fileNames = { "Mercury.txt", "Luna.txt" };
        for (String fileName : fileNames) {
            System.out.println(fileName + " is magic? " + testMagic(fileName));
        }
    }
}
