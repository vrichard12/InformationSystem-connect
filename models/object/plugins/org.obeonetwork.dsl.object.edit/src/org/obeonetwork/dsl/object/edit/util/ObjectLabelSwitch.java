package org.obeonetwork.dsl.object.edit.util;

import java.util.Arrays;
import java.util.Objects;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.object.LiteralValue;
import org.obeonetwork.dsl.object.ObjectPackage;
import org.obeonetwork.dsl.object.ObjectProperty;
import org.obeonetwork.dsl.object.ObjectValue;
import org.obeonetwork.dsl.object.PrimitiveTypeValue;
import org.obeonetwork.dsl.object.Value;
import org.obeonetwork.dsl.object.Workspace;
import org.obeonetwork.dsl.object.util.ObjectSwitch;

public class ObjectLabelSwitch extends ObjectSwitch<String> {
	
	private static final ObjectLabelSwitch INSTANCE = new ObjectLabelSwitch();

	private String getValueTypeName(Value value) {
		return (value.getMetaType() != null)? value.getMetaType().getName() : "---";
	}
	
	private String getObjectValueNameGuess(ObjectValue objectValue) {
		return Arrays.asList("name", "key").stream()
		.flatMap(name -> objectValue.getProperties().stream()
				.filter(p -> name.equalsIgnoreCase(p.getName())))
		.map(p -> getValuesLabel(p.getValues(), p.isMultiple()))
		.findFirst().orElse("<ObjectValue>");
	}

	@Override
	public String caseObjectValue(ObjectValue objectValue) {
		return getObjectValueNameGuess(objectValue) + " : " + getValueTypeName(objectValue);
	}
	
	@Override
	public String casePrimitiveTypeValue(PrimitiveTypeValue primitiveTypeValue) {
		return getShortValueLabel(primitiveTypeValue) + " : " + getValueTypeName(primitiveTypeValue);
	}

	@Override
	public String caseLiteralValue(LiteralValue literalValue) {
		return getShortValueLabel(literalValue) + " : " + getValueTypeName(literalValue);
	}
	
	
	@Override
	public String caseObjectProperty(ObjectProperty property) {
		return property.getName() + " = " + getValuesLabel(property.getValues(), property.isMultiple());
	}

	private String getValuesLabel(EList<Value> values, boolean multiple) {
		if(!multiple) {
			return (values.isEmpty())? 
				"()" :
				getShortValueLabel(values.get(0));
		} else {
			StringBuffer label = new StringBuffer();
			label.append("{");
			if(!values.isEmpty()) {
				label.append(getShortValueLabel(values.get(0)));
			}
			if(values.size() > 1) {
				label.append(",...");
			}
			label.append("}");
			return label.toString();
		}
	}

	private String getShortValueLabel(Value value) {
		String label = null;
		switch(value.eClass().getClassifierID()) {
		case ObjectPackage.PRIMITIVE_TYPE_VALUE:
			label = Objects.toString(((PrimitiveTypeValue)value).getData());
			break;
		case ObjectPackage.LITERAL_VALUE:
			label = ((LiteralValue)value).getName();
			break;
		case ObjectPackage.OBJECT_VALUE:
			label = getObjectValueNameGuess((ObjectValue) value);
			break;
		}
		return label;
	}

	@Override
	public String caseWorkspace(Workspace workspace) {
		return workspace.getName();
	}

	public static String getObjectLabel(EObject eObject) {
		return INSTANCE.doSwitch(eObject);
	}
	
	public static String truncateObjectLabel(String label) {
		if(label.length() > 38) {
			return label.substring(0, 38) + "...";
		}
		return label;
	}

}
