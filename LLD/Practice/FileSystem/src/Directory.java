import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{
    String directoryName;
    List<FileSystem> fileSystemList;

    public Directory(String directoryName){
        this.directoryName = directoryName;
        fileSystemList = new ArrayList<>();
    }

    public void add(FileSystem fileSystem){
        fileSystemList.add(fileSystem);
    }

    @Override
    public void ls(int depth) {
        System.out.println(getIndent(depth)+"- Directory Name : "+this.directoryName);
        for (FileSystem fileSystem: fileSystemList){
            fileSystem.ls(depth+1);
        }
    }

    public String getIndent(int depth){
        return " ".repeat(depth);
    }
}
