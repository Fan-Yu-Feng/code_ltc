package com.design.model.build.builder;

import com.design.model.build.car.BenzModel;
import com.design.model.build.car.BmwModel;
import com.design.model.build.car.CarModel;
import com.enums.SequencesEnum;

import java.util.ArrayList;

/**
 * @author FYF
 * @date 2022/8/13
 */
public class BmwBuilder extends CarBuilder {
	private final CarModel bmwModel = new BmwModel();
	
	@Override
	public void setSequence(ArrayList<SequencesEnum> sequence) {
		this.bmwModel.setSequence(sequence);
	}
	
	@Override
	public CarModel getCarModel() {
		return bmwModel;
	}
}