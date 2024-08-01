import java.util.Random;

class Chopstick {}

class Diner extends Thread {
  private Chopstick first, second;
  private Random random;

  public Diner(Chopstick left, Chopstick right) {
    if (left.getId() < right.getId()) {
    this.first = left; this.second = right;
    } else {
    this.second = left; this.first = right;
    }
    random = new Random();
  }

  public void run() {
    try {
      while(true) {
        Thread.sleep(random.nextInt(1000));
        synchronized(left) {
          System.out.println("got left");
          synchronized(right) {
          System.out.println("got right");
            Thread.sleep(random.nextInt(1000));
          }
        }
      }
    } catch(InterruptedException e) {}
  }
}

class Philosopher {
  public static void main(String[] args) {
    Diner diner = new Diner(new Chopstick(), new Chopstick());
    diner.run();

  }
}
