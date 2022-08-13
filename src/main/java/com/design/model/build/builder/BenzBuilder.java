package com.design.model.build.builder;

import com.design.model.build.car.BenzModel;
import com.design.model.build.car.CarModel;
import com.enums.SequencesEnum;

import java.util.ArrayList;

/**
 * @author FYF
 * @date 2022/8/13
 */
public class BenzBuilder extends CarBuilder {
	private final CarModel benzModel = new BenzModel();
	
	@Override
	public void setSequence(ArrayList<SequencesEnum> sequence) {
		this.benzModel.setSequence(sequence);
	}
	
	@Override
	public CarModel getCarModel() {
		return benzModel;
	}
}