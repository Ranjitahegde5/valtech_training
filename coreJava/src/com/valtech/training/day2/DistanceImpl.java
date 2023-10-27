package com.valtech.training.day2;

public class DistanceImpl implements Distance {
	
	private Arithmetic arithmetic;
	
	public DistanceImpl(Arithmetic arithmetic) {
		this.arithmetic=arithmetic;
	}
	
	

	public void setArithmetic(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}



	@Override
	public double computeDistance(int PointA, int PointB) {
		int result = arithmetic.add(int PointA, int PointB);
		int result = arithmetic.sub(int PointB, int PointA);
		
		return arithmetic.sub(result, result);
		
		return 0;
	} 

	


	
	

}
