package DataRace;

public class DataRace2 {
    public static void main(String[] args) {
        SharedData data = new SharedData();

        Thread writer = new Thread(() -> {
            data.flag = true;  // Writer thread updates
            System.out.println("Flag updated by Writer");
        });

        Thread reader = new Thread(() -> {
            while (!data.flag) {
                // Might run forever due to CPU caching
                System.out.println("In the reader loop");
            }
            System.out.println("Flag changed : " + data.flag); 
        });

        writer.start();
        reader.start();
    }

    static class SharedData {
        boolean flag = false;  // Not volatile
    }
}
