package ruleengine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TriggeredValuesRule extends ConstantValuesRule implements Rule {

	private Rule triggeringRule;
	
	public TriggeredValuesRule(Rules rules, String triggeringPropertyName, String targetedPropertyName, Object[] values) {
		
		this(rules.getRuleForProperty(triggeringPropertyName), triggeringPropertyName, targetedPropertyName, values);
		
	}

	public TriggeredValuesRule(Rule triggeringRule,
			String triggeringPropertyName, String targetedPropertyName,
			Object[] values) {
			super(targetedPropertyName, values);
			this.triggeringRule = triggeringRule;
			
			List<Object> redValues = new ArrayList<Object>(); 
			List<Object> ringValues = new ArrayList<Object>(); 
			for (Object ringValue: triggeringRule.getValues()) {
				ringValues.addAll(Collections.nCopies(getValues().length, ringValue));
				redValues.addAll(Arrays.asList(getValues()));
			}
			triggeringRule.setValues(ringValues.toArray());
			setValues(redValues.toArray());
	}
	



}
