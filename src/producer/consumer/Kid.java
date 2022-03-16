package producer.consumer;

public class Kid implements Runnable {

  private final Workshop workshop;

  public Kid(Workshop workshop) {
    this.workshop = workshop;
  }

  void makeWish() {
    Gift gift = Gift.getGifts();
    workshop.postWish(gift);
  }

  @Override
  public void run() {
    try {
      Thread.sleep(1000);
      makeWish();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}

