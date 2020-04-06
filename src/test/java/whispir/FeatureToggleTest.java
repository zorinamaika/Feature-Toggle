package whispir;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FeatureToggleTest {

	@Test
	public void addFeatureToggleTest() throws FeatureDoesNotExistException {
		FeatureCollection features = new FeatureCollection();
		
		FeatureToggle feature = new FeatureToggle();
		feature.setFeatureName("testFeature");
		feature.setEnabled(true);	
		features.addFeatureToggle(feature);
		
		assertTrue(features.getFeatureToggle(feature.getFeatureName()));		
	}
	
	@Test(expected=FeatureDoesNotExistException.class)
	public void getFeatureToggleWhenDoesntExistTest() throws FeatureDoesNotExistException {
		FeatureCollection features = new FeatureCollection();
		
		features.getFeatureToggle("not existing test");
	}
	
	@Test(expected=FeatureDoesNotExistException.class)
	public void deleteFeatureToggleTest() throws FeatureDoesNotExistException {
		FeatureCollection features = new FeatureCollection();
		
		FeatureToggle feature = new FeatureToggle();
		feature.setFeatureName("testFeature");
		feature.setEnabled(true);
		
		features.addFeatureToggle(feature);	
		features.deleteFeatureToggle(feature);
		
		features.getFeatureToggle(feature.getFeatureName());
	}
	
	@Test
	public void updateFeatureToggleTest() throws FeatureDoesNotExistException {
		FeatureCollection features = new FeatureCollection();
		
		FeatureToggle feature = new FeatureToggle();
		feature.setFeatureName("testFeature");
		feature.setEnabled(true);
		
		features.addFeatureToggle(feature);			
		feature.setEnabled(false);
		features.updateFeatureToggle(feature);
		
		assertFalse(features.getFeatureToggle(feature.getFeatureName()));
	}
	
	@Test(expected=FeatureDoesNotExistException.class)
	public void deleteFeatureToggleDoesNotExistTest() throws FeatureDoesNotExistException {
		FeatureCollection features = new FeatureCollection();
		FeatureToggle feature = new FeatureToggle();
		feature.setFeatureName("not existing test");
		
		features.deleteFeatureToggle(feature);
	}
	
}
