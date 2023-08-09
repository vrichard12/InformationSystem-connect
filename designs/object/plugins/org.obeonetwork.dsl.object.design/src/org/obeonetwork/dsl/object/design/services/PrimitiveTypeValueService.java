package org.obeonetwork.dsl.object.design.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.obeonetwork.dsl.environment.PrimitiveType;
import org.obeonetwork.dsl.object.PrimitiveTypeValue;

public class PrimitiveTypeValueService {

	public static PrimitiveTypeValue setStringData(PrimitiveTypeValue self, String data) {
		self.setData(data);
		return self;
	}
	
	@SuppressWarnings("serial")
	private static final Map<String, Object> PRIMITIVE_TYPES_DEFAULT_VALUES = new HashMap<String, Object>() {{
		put("Boolean", Boolean.TRUE);
		put("Date", new Date());
		put("Double", Double.valueOf(0));
		put("Float", Float.valueOf(0));
		put("Integer", Integer.valueOf(0));
		put("Long", Long.valueOf(0));
		put("String", "");
	}};
	
	public static PrimitiveTypeValue setDefaultPrimitiveTypeData(PrimitiveTypeValue self) {
		Object defaultData = null;
		if(self.getMetaType() instanceof PrimitiveType) {
			PrimitiveType primitiveType = (PrimitiveType) self.getMetaType();
			defaultData = PRIMITIVE_TYPES_DEFAULT_VALUES.get(primitiveType.getName());
		}
		
		self.setData(defaultData);
		return self;
	}
	
}
