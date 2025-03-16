package semaphores.clubentry;

import java.util.concurrent.Semaphore;


public class Club {

    private final Semaphore semaphore;

    public Club(int capacity) {
        this.semaphore = new Semaphore(capacity);
    }

    public void enterClub(String person) throws InterruptedException {
        System.out.println(person + " is entering the club");
        semaphore.acquire();
        System.out.println(person + " has entered!");

        Thread.sleep(2000); // time spent inside the club

        System.out.println(person + " is leaving...");
        semaphore.release();
    }

}
