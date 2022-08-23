package org.designpattern.construction.builder._02_after;

import java.time.LocalDate;
import java.util.List;

import org.designpattern.construction.builder._01_before.DetailPlan;
import org.designpattern.construction.builder._01_before.TourPlan;

public class Main {

	public static void main(String[] args) {
		DetailPlan detailPlan1 = DetailPlan.builder()
			.day(0)
			.plan("체크인 이후 짐풀기")
			.build();
		System.out.println("detailPlan1 = " + detailPlan1);

		DetailPlan detailPlan2 = DetailPlan.builder()
			.day(1)
			.plan("조식 부페에서 식사")
			.build();

		DetailPlan detailPlan3 = DetailPlan.builder()
			.day(2)
			.plan("중식식 부페에서 식사")
			.build();

		TourPlan tourPlan = TourPlan.builder()
			.title("오레곤 롱비치 여행")
			.days(55)
			.nights(54)
			.whereToStay("호텔")
			.plans(List.of(detailPlan1, detailPlan2, detailPlan3))
			.startDate(LocalDate.of(2021, 11, 15))
			.build();
		System.out.println("tourPlan = " + tourPlan);
	}
}

/*
점층적 생성자를 이용하느니 Builder Pattern 쓰는 것이 낫다
다만 클라이언트에게 지나치게 큰 자율성을 준다는 문제가 생긴다
즉 DDD 개념에서 일관성이 보장되지 않는 상태로 만들어질 수 있다, 어떻게 해결할 수 있는가?

- 중간 Layer 하나 더 만들어서 팩토리 메서드로 사용한다 (빌더 쓸 이유가 있나?)
- 개발자에게 자유를 준다 (결국 어떤 인자들이 필수이고 지켜야 할 사항이 있는지 세부 구현을 다 까봐야 한다)
 */