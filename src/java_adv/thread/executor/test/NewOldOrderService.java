package java_adv.thread.executor.test;

import java.util.concurrent.*;

import static java_adv.util.MyLogger.log;
import static java_adv.util.ThreadUtils.sleep;

public class NewOldOrderService {

    private final ExecutorService es = Executors.newFixedThreadPool(10);

    public void order(String orderNo) throws ExecutionException, InterruptedException {
        InventoryWork inventoryWork = new InventoryWork(orderNo);
        ShippingWork shippingWork = new ShippingWork(orderNo);
        AccountingWork accountingWork = new AccountingWork(orderNo);

        // 작업 요청
        Future<Boolean> inventoryFuture = es.submit(inventoryWork);
        Future<Boolean> shippingFuture = es.submit(shippingWork);
        Future<Boolean> accountFuture = es.submit(accountingWork);

        Boolean inventoryResult = inventoryFuture.get();
        Boolean shippingResult = shippingFuture.get();
        Boolean accountResult = accountFuture.get();

        // 결과 확인
        if (inventoryResult && shippingResult && accountResult) {
            log("모든 주문 처리가 성공적으로 완료되었습니다.");
        } else {
            log("일부 작업이 실패했습니다.");
        }
    }

    static class InventoryWork implements Callable<Boolean> {

        private final String orderNo;

        public InventoryWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() {
            log("재고 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }

    static class ShippingWork implements Callable<Boolean> {

        private final String orderNo;

        public ShippingWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() {
            log("배송 시스템 알림: " + orderNo);
            sleep(1000);
            return true;
        }
    }

    static class AccountingWork implements Callable<Boolean> {

        private final String orderNo;

        public AccountingWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() {
            log("회계 시스템 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }

}