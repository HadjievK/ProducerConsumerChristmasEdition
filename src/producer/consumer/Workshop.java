package producer.consumer;

import java.util.LinkedList;
import java.util.Queue;

public class Workshop {
  private static final int TOTAL_NUMBER_OF_ELVES = 20;
  private volatile boolean isChristmasTime = false;
  private volatile int wishCounter = 0;

  private final Queue<Gift> backlog = new LinkedList<>();
  private final Elf[] elves;

  public Workshop() {
    this.elves = new Elf[TOTAL_NUMBER_OF_ELVES];

    for (int i = 0; i < TOTAL_NUMBER_OF_ELVES; i++) {
      elves[i] = new Elf(i, this);
      elves[i].start();
    }
  }

  /**
   * Adds gift to the elves' backlog
   **/

  public synchronized void postWish(Gift gift) {
    backlog.add(gift);
    System.out.println("a gift was added");
    wishCounter++;

    this.notify();
  }


  /**
   * returns an array of the elves working in Santa's workshop
   */
  public Elf[] getElves() {
    return elves;
  }

  public synchronized Gift nextGift() {

    while (!isChristmasTime && backlog.isEmpty()) {
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("poll gift");


    if (isChristmasTime || backlog.isEmpty()) {
      return null;
    } else {

      return backlog.poll();
    }

  }

  /**
   * Returns the total numbers of wishes sent to Santa's workshop
   */
  public int getWishCount() {
    return wishCounter;

  }

  public synchronized void setTime() {
    this.isChristmasTime = true;
    notifyAll();
  }
}
