package org.designpattern.construction.builder._01_before;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailPlan {

	private int day;

	private String plan;

	public static DetailPlanBuilder builder() {
		return new DetailPlanBuilder();
	}

	@NoArgsConstructor
	@AllArgsConstructor
	public static class DetailPlanBuilder {

		private int day;
		private String plan;

		public DetailPlanBuilder day(int day) {
			this.day = day;
			return this;
		}

		public DetailPlanBuilder plan(String plan) {
			this.plan = plan;
			return this;
		}

		public DetailPlan build() {
			return new DetailPlan(day, plan);
		}
	}
}
