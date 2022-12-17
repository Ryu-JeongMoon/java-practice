package net.jcip.examples;

/**
 * InduceLockOrder
 * <p>
 * Inducing a lock order to avoid deadlock
 *
 * @author Brian Goetz and Tim Peierls
 */
public class InduceLockOrder {

	private static final Object tieLock = new Object();

	public void transferMoney(
		final Account fromAcct,
		final Account toAcct,
		final DollarAmount amount
	) throws InsufficientFundsException {

		class Helper {

			public void transfer() throws InsufficientFundsException {
				if (fromAcct.getBalance().compareTo(amount) < 0) {
					throw new InsufficientFundsException();
				} else {
					fromAcct.debit(amount);
					toAcct.credit(amount);
				}
			}
		}

		// System.identityHashCode()
		// 서로 다른 객체에서 동일한 해시코드를 반환할 가능성이 거의 없으므로 최소한의 비용으로 최대 효과를 낸다
		// 만약 동일한 해시코드를 반환하는 경우를 위해 tieLock을 사용한다
		int fromHash = System.identityHashCode(fromAcct);
		int toHash = System.identityHashCode(toAcct);

		if (fromHash < toHash) {
			synchronized (fromAcct) {
				synchronized (toAcct) {
					new Helper().transfer();
				}
			}
		} else if (fromHash > toHash) {
			synchronized (toAcct) {
				synchronized (fromAcct) {
					new Helper().transfer();
				}
			}
		} else {
			synchronized (tieLock) {
				synchronized (fromAcct) {
					synchronized (toAcct) {
						new Helper().transfer();
					}
				}
			}
		}
	}

	interface DollarAmount extends Comparable<DollarAmount> {

	}

	interface Account {

		void debit(DollarAmount d);

		void credit(DollarAmount d);

		DollarAmount getBalance();

		int getAcctNo();
	}

	static class InsufficientFundsException extends Exception {

	}
}
