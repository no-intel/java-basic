package java_adv.thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java_adv.util.MyLogger.log;
import static java_adv.util.ThreadUtils.sleep;

public class BankAccountV4 implements BankAccount {

    private int balance;

    private final Lock lock = new ReentrantLock();

    public BankAccountV4(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());

        lock.lock();
        try {
            log("[검증 시작] 출금액: " + amount + ", 잔액:" + balance);
            if (balance < amount) {
                log("[검증 실패]");
                return false;
            }
            log("[검증 완료] 출금액: " + amount + ", 잔액:" + balance);
            sleep(1000);

            balance -= amount;
            log("[출금완료 완료] 출금액: " + amount + ", 잔액:" + balance);
        }finally {
            lock.unlock();
        }

        log("거래 종료");
        return true;
    }

    @Override
    public int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
