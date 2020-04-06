package whispir;

import java.util.HashMap;
import java.util.Map;

public class FeatureCollection {
	
	private Map<String, Boolean> featureMap = new HashMap<>();
	
	public void addFeatureToggle(FeatureToggle feature) {
		featureMap.put(feature.getFeatureName(), feature.isEnabled());
	}
	
	public void deleteFeatureToggle(FeatureToggle feature) throws FeatureDoesNotExistException {
		if(featureMap.containsKey(feature.getFeatureName())) {
			featureMap.remove(feature.getFeatureName());
		} else {
			throw new FeatureDoesNotExistException();
		}
	}
	
	public boolean getFeatureToggle(String featureName) throws FeatureDoesNotExistException {
		if(featureMap.containsKey(featureName)) {
			return featureMap.get(featureName);
		} else {
			throw new FeatureDoesNotExistException();
		}
	}
	
	public void updateFeatureToggle(FeatureToggle feature) throws FeatureDoesNotExistException {
		if(featureMap.containsKey(feature.getFeatureName())) {
			featureMap.put(feature.getFeatureName(), feature.isEnabled());
		} else {
			throw new FeatureDoesNotExistException();
		}
	}
}
