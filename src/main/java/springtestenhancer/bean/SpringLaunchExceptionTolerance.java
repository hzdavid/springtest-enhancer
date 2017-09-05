package springtestenhancer.bean;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

/**
 * Tolerance to the exception when spring launches. for example: let program move on if dependency injection failed
 * 
 * @author david
 *
 */

public class SpringLaunchExceptionTolerance implements BeanFactoryPostProcessor {

	// disable dependency checking
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] beanNames = beanFactory.getBeanDefinitionNames();
		for (int i = 0; i < beanNames.length; i++) {
			BeanDefinition bd = beanFactory.getBeanDefinition(beanNames[i]);
			((AbstractBeanDefinition) bd).setDependencyCheck(AbstractBeanDefinition.DEPENDENCY_CHECK_NONE);
			if (CommonAnnotationBeanPostProcessor.class.getName().equals(bd.getBeanClassName())) {
				bd.setBeanClassName(CommonAnnotationBeanPostProcessorX.class.getName());
			}
			if (AutowiredAnnotationBeanPostProcessor.class.getName().equals(bd.getBeanClassName())) {
				bd.setBeanClassName(AutowiredAnnotationBeanPostProcessorX.class.getName());
			}
			if (RequiredAnnotationBeanPostProcessor.class.getName().equals(bd.getBeanClassName())) {
				bd.setBeanClassName(RequiredAnnotationBeanPostProcessorX.class.getName());
			}
		}
	}

	// let program move on if dependency injection failed
	public static class CommonAnnotationBeanPostProcessorX extends CommonAnnotationBeanPostProcessor {
		private static final long serialVersionUID = -3873308295801844911L;

		@Override
		public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
			try {
				super.postProcessPropertyValues(pvs, pds, bean, beanName);
			} catch (Throwable ex) {
				ex.printStackTrace();
			}
			return pvs;
		}
	}

	// let program move on if dependency injection failed
	public static class AutowiredAnnotationBeanPostProcessorX extends AutowiredAnnotationBeanPostProcessor {
		@Override
		public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
			try {
				super.postProcessPropertyValues(pvs, pds, bean, beanName);
			} catch (Throwable ex) {
				ex.printStackTrace();
			}
			return pvs;
		}

		@Override
		public void processInjection(Object bean) throws BeansException {
			try {
				super.processInjection(bean);
			} catch (Throwable ex) {
				logger.error(ex);
			}
		}
	}

	// let program move on if dependency injection failed
	public static class RequiredAnnotationBeanPostProcessorX extends RequiredAnnotationBeanPostProcessor {
		@Override
		public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
			try {
				super.postProcessPropertyValues(pvs, pds, bean, beanName);
			} catch (Throwable ex) {
				ex.printStackTrace();
			}
			return pvs;
		}
	}
}
