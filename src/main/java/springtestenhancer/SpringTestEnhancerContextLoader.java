package springtestenhancer;

import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextLoader;
import org.springframework.test.context.MergedContextConfiguration;
import org.springframework.test.context.support.AbstractContextLoader;

/**
 * customize ContextLoader to load the SpringTestEnhancerContext
 *
 * @author david
 *
 */
public class SpringTestEnhancerContextLoader implements ContextLoader {

	private static class ContextLoader4TestInner extends AbstractContextLoader {
		public ApplicationContext loadContext(String... locations) throws Exception {
			return new SpringTestEnhancerContext(locations);
		}

		public ApplicationContext loadContext(MergedContextConfiguration mergedConfig) throws Exception {
			return loadContext(mergedConfig.getLocations());
		}

		@Override
		protected String getResourceSuffix() {
			return "-context.xml";
		}

	}

	static ContextLoader loader = new ContextLoader4TestInner();

	public String[] processLocations(Class<?> clazz, String... locations) {
		String enhancerXml = "classpath:META-INF/springtestenhancer/bean/enhancer.xml";
		String[] a = locations;
		String[] b = new String[a.length + 1];
		for (int i = 0; i < b.length; i++) {
			if (i == b.length - 1) {
				b[i] = enhancerXml;
			} else {
				b[i] = a[i];
			}
		}
		return loader.processLocations(clazz, b);
	}

	public ApplicationContext loadContext(String... locations) throws Exception {
		return loader.loadContext(locations);
	}

}
