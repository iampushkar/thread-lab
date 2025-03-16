package semaphores.clubentry;

public class ClubMain {
    public static void main(String[] args) {
        Club club = new Club(5);

        Runnable person = () -> {
            try {
                club.enterClub(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(person, "Person-" + (i+1)).start();
        }
    }
}
