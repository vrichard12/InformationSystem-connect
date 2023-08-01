package org.obeonetwork.dsl.object.design.services;

import org.obeonetwork.dsl.object.PrimitiveTypeValue;

public class PrimitiveTypeValueService {

	public static PrimitiveTypeValue setStringData(PrimitiveTypeValue self, String data) {
		self.setData(data);
		return self;
	}
}
