public class File implements FileSystem{
    String fileName;

    public File(String name){
        this.fileName = name;
    }

    @Override
    public void ls(int depth) {
        System.out.println(getIndent(depth)+"- File Name : "+this.fileName);
    }

    public String getIndent(int depth){
        return " ".repeat(depth);
    }
}
