public class Puzzle {
  static boolean answerReady = false;
  static int answer = 0;

      static Thread t1 = new Thread() {
        public void run() {
          answer = 42;
          answerReady = true;
        }
      };

      static Thread t2 = new Thread() {
        public void run() {
          if (answer != 42) 
            System.out.print(answer);
        }
      };

  public static void main(String[] args) throws InterruptedException {
      t1.start(); t2.start();
      t1.join(); t2.join();
  }
}
