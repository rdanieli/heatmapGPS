package com.eng.univates.pojo;

import java.io.Serializable;

public class ConsultaRotaBatalhao implements Serializable {
		private String lat;
		private String lng;
		private Double distance;
		
		public ConsultaRotaBatalhao() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((distance == null) ? 0 : distance.hashCode());
			result = prime * result + ((lat == null) ? 0 : lat.hashCode());
			result = prime * result + ((lng == null) ? 0 : lng.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ConsultaRotaBatalhao other = (ConsultaRotaBatalhao) obj;
			if (distance == null) {
				if (other.distance != null)
					return false;
			} else if (!distance.equals(other.distance))
				return false;
			if (lat == null) {
				if (other.lat != null)
					return false;
			} else if (!lat.equals(other.lat))
				return false;
			if (lng == null) {
				if (other.lng != null)
					return false;
			} else if (!lng.equals(other.lng))
				return false;
			return true;
		}
		public String getLat() {
			return lat;
		}
		public void setLat(String lat) {
			this.lat = lat;
		}
		public String getLng() {
			return lng;
		}
		public void setLng(String lng) {
			this.lng = lng;
		}
		public Double getDistance() {
			return distance;
		}
		public void setDistance(Double distance) {
			this.distance = distance;
		}
}
