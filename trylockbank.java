import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// one for e-commers ordering
public class trylockbank {

    public static void main(String[] args) {
        Account A = new Account("a", 100);
        Account B = new Account("b", 100);

        Thread t1 = new Thread(() -> Account.transfer(a, b, 100), "T1");
        Thread t2 = new Thread(() -> Account.transfer(b, a, 200), "T2");

        A.start();
        B.start();

        Thread.sleep(500);
        System.out.println("After 500ms: T1 alive? " + t1.isAlive() + ", T2 alive? " + t2.isAlive());
        System.out.println("Balances: A=" + a.getBalance() + " B=" + b.getBalance());

    }

    static class Account {

        private final String name;
        private int balance;

        public Account(String name, int balance) {
            this.balance = balance;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getBalance() {
            return balance;
        }

        public void deposit(int deposit) {
            balance += deposit;
        }

        public void widraw(int widraw) {
            balance -= widraw;
        }


        public static void transfer(Account from, Account to, int amount) {
            synchronized(from) {
                System.out.println(Thread.currentThread.getName() + " locked " + from.getName());
                try(Thread.sleep(50)) catch(InterruptedException e) {}
                synchronized(to) {
                    System.out.println(Thread.currentTread.getName() + " locked " + to.getName());
                    from.widraw(amount);
                    to.deposit(amount);

                    System.out.printf(" %s: transfererd %d  from %s to %s%n", Thread.currentThread.getName(), amount, from.getName(), to.getName());
                }
            }
        }
    }
}
