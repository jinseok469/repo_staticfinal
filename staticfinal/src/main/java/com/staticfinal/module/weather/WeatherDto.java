package com.staticfinal.module.weather;

public class WeatherDto {
		private String icon;
		private double min;
		private double max;
		private String date;
		
		
		
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public double getMin() {
			return min;
		}
		public void setMin(double min) {
			this.min = min;
		}
		public double getMax() {
			return max;
		}
		public void setMax(double max) {
			this.max = max;
		}
		
		
		
}
