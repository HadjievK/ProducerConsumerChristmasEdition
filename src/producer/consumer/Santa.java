package producer.consumer;

public class Santa {
  private final Workshop workshop;
  private final int kidsNumber;

  public Santa(Workshop workshop, int kidsNumber) {
    this.workshop = workshop;
    this.kidsNumber = kidsNumber;
  }

  public Workshop getWorkshop() {
    return workshop;
  }

  public void simulateChristmas() {
    Thread[] kids = new Thread[kidsNumber];
    for (int i = 0; i < kids.length; i++) {
      kids[i] = new Thread(new Kid(workshop));
      kids[i].start();

    }
    try {
      System.out.println("wait 3 sec to Christmas");
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    synchronized (workshop) {
      workshop.setTime();
    }

  }
}
