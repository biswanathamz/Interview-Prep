public interface FileSystem {
    public void ls(int depth);
    default void ls(){ls(0);}
}
