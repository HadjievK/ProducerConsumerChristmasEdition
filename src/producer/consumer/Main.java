package producer.consumer;

public class Main {

  public static void main(String[] args) {
    int numberOfKids = 45;
    Workshop w = new Workshop();
    Santa s = new Santa(w, numberOfKids);
    s.simulateChristmas();

  }
}
