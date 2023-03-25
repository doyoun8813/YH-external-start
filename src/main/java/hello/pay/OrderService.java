package hello.pay;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final PayClient payClient;

	public void order(int money) {
		// 주문 로직
		payClient.pay(money);
	}
}
