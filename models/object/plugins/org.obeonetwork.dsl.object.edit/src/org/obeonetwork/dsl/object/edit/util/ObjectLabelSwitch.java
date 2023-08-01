package org.obeonetwork.dsl.object.edit.util;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.object.LiteralValue;
import org.obeonetwork.dsl.object.ObjectValue;
import org.obeonetwork.dsl.object.PrimitiveTypeValue;
import org.obeonetwork.dsl.object.Value;
import org.obeonetwork.dsl.object.util.ObjectSwitch;

public class ObjectLabelSwitch extends ObjectSwitch<String> {
	
	private static final ObjectLabelSwitch INSTANCE = new ObjectLabelSwitch();

	private String getValueTypeName(Value value) {
		return (value.getMetaType() != null)? value.getMetaType().getName() : "---";
	}
	
	@Override
	public String caseObjectValue(ObjectValue object) {
		// aql:': ' + if self.metaType <> null then self.metaType.name else '---' endif
		return ": " + getValueTypeName(object);
	}
	
	@Override
	public String casePrimitiveTypeValue(PrimitiveTypeValue object) {
		// aql:self.value.toString() + ' : ' + if self.metaType <> null then self.metaType.name else '---' endif
		return Objects.toString(object.getData()) + " : " + getValueTypeName(object);
	}

	@Override
	public String caseLiteralValue(LiteralValue object) {
		// aql:self.name + ' : ' + if self.metaType <> null then self.metaType.name else '---' endif
		return object.getName() + " : " + getValueTypeName(object);
	}
	
	public static String getObjectLabel(EObject eObject) {
		return INSTANCE.doSwitch(eObject);
	}

}
