package org.designpattern.construction.builder._01_before;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourPlan {

	private String title;

	private int nights;

	private int days;

	private LocalDate startDate;

	private String whereToStay;

	private List<DetailPlan> plans;

	public void addPlan(int day, String plan) {
		this.plans.add(new DetailPlan(day, plan));
	}

	public static TourPlanBuilder builder() {
		return new TourPlanBuilder();
	}

	public static class TourPlanBuilder {

		private String title;

		private int nights;

		private int days;

		private LocalDate startDate;

		private String whereToStay;

		private List<DetailPlan> plans;

		public TourPlanBuilder title(String title) {
			this.title = title;
			return this;
		}

		public TourPlanBuilder nights(int nights) {
			this.nights = nights;
			return this;
		}

		public TourPlanBuilder days(int days) {
			this.days = days;
			return this;
		}

		public TourPlanBuilder startDate(LocalDate startDate) {
			this.startDate = startDate;
			return this;
		}

		public TourPlanBuilder whereToStay(String whereToStay) {
			this.whereToStay = whereToStay;
			return this;
		}

		public TourPlanBuilder plans(List<DetailPlan> plans) {
			this.plans = plans;
			return this;
		}

		public TourPlan build() {
			return new TourPlan(title, nights, days, startDate, whereToStay, plans);
		}
	}
}

/*
gradle
out > production > classes 하위 클래스 살펴보면 이와 유사한 형태로 Lombok Builder 생성 됨
 */