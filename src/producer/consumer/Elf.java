package producer.consumer;

public class Elf extends Thread {
  private final Workshop workshop;
  private final int id;
  private int totalGiftCrafted;

  public Elf(int id, Workshop workshop) {

    this.id = id;
    this.workshop = workshop;
  }

  /**
   * Gets a wish from the backlog and creates the wanted gift.
   **/
  public void craftGift() {
    Gift currentGift = null;
    while ((currentGift = workshop.nextGift()) != null) {
      try {
        Thread.sleep(currentGift.getCraftTime());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }


  @Override
  public void run() {
    craftGift();

  }
}
