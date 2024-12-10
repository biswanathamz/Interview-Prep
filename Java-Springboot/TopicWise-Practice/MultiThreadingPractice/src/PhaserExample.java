import java.util.concurrent.Phaser;

class MyThread{
    Phaser phaser;
    String name;

    MyThread(Phaser phaser, String name){
        this.phaser = phaser;
        this.name = name;
        this.phaser.register();
    }

    Runnable r = () -> {
        System.out.println("Thread : "+this.name+" Beginning phase 1");
        this.phaser.arriveAndAwaitAdvance();
    };

}
public class PhaserExample {

    public void demo(){

    }
}
