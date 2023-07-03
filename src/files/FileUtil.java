package files;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileUtil {

    static class FileNode {
        public long inode;

        public long pInode;

        public String filename;

        public String dentry;

        public long size;

        public long modifyTime;
    }

    public static List<FileNode> dfsRead(File directory) {
        File[] files = directory.listFiles();
        List<FileNode> fileNodes = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
//                    System.out.println("Directory: " + file.getAbsolutePath());
                    FileNode fileNode = new FileNode();
                    fileNodes.add(fileNode);
                    fileNodes.addAll(dfsRead(file));
                } else {
                    FileNode fileNode = new FileNode();
                    fileNodes.add(fileNode);
//                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        }
        return fileNodes;
    }

    public static List<FileNode> bfsRead(File root) {
        List<FileNode> ansList = new ArrayList<>();
        LinkedList<File> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                File curFile = queue.pollFirst();
                File[] subFiles = curFile.listFiles();
                if (subFiles != null) {
                    for (File subFile: subFiles) {
                        if (subFile.isDirectory()) {
                            ansList.add(new FileNode());
                            queue.addLast(subFile);
                        } else {
                            ansList.add(new FileNode());
                        }
                    }
                }
            }
        }
        return ansList;
    }

    private static List<FileNode> readDirectory(Path directory) throws IOException {
        List<FileNode> ansList = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path file : stream) {
                if (Files.isDirectory(file)) {
                    ansList.add(new FileNode());
                    ansList.addAll(readDirectory(file));
                } else {
                    ansList.add(new FileNode());
                }
            }
        }
        return ansList;
    }

    public static List<FileNode> nioRead(File root) {
        List<FileNode> fileNodes = new ArrayList<>();
        Path directory = Paths.get(root.getPath());

        try {
//            fileNodes = readDirectory(directory);
            Files.walk(directory)
                    .forEach(path -> {
                        fileNodes.add(new FileNode());
//                        System.out.println(path.getFileName());
                    });
        } catch (Exception e) {
            System.out.println("error message : " + e.getMessage());
        }
        return fileNodes;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        File directory = new File("/Users/yuruiyin/gaoding/FS-SDK/.watched-dir");
//        List<FileNode> fileNodes = dfsRead(directory);
//        List<FileNode> fileNodes = bfsRead(directory);
        List<FileNode> fileNodes = nioRead(directory);
        System.out.println("文件个数: " + fileNodes.size());
        System.out.println("递归获取文件目录树耗时: " + (System.currentTimeMillis() - start) + "ms");
    }

}
