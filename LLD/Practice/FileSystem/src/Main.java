public class Main {
    public static void main(String[] args) {
        Directory directory = new Directory("Movie");

        File dummyMovie = new File("Dummy Movie");
        directory.add(dummyMovie);

        Directory hindiMovieDir = new Directory("Hindi");
        hindiMovieDir.add(new File("Krish"));

        directory.add(hindiMovieDir);
        directory.add(new Directory("Bengali"));
        directory.add(new Directory("English"));



        directory.ls();
    }
}