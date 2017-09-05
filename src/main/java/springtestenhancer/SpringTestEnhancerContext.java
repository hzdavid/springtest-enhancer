package springtestenhancer;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * customize SpringContainer
 * 
 * @author david
 *
 */
public class SpringTestEnhancerContext extends ClassPathXmlApplicationContext {

	public SpringTestEnhancerContext(String configLocation) throws BeansException {
		this(new String[] { configLocation });
	}

	public SpringTestEnhancerContext(String[] configLocations) throws BeansException {
		super(configLocations);
	}

	@Override
	public void refresh() throws BeansException, IllegalStateException {
		try {
			super.refresh();
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void finishRefresh() throws BeansException, IllegalStateException {
		try {
			super.finishRefresh();
		} catch (Throwable e1) {
			e1.printStackTrace();
		}

	}

	@Override
	protected void destroyBeans() {
		// do nothing...

	}

	@Override
	protected void cancelRefresh(BeansException ex) {
		// do nothing...
	}

	@Override
	protected void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
		try {
			super.invokeBeanFactoryPostProcessors(beanFactory);
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
	}

	// customize DefaultListableBeanFactory
	@Override
	protected DefaultListableBeanFactory createBeanFactory() {
		return new DefaultListableBeanFactory(getInternalParentBeanFactory()) {
			// if creating bean doesn't succeed, continue..
			@Override
			protected Object doCreateBean(String beanName, RootBeanDefinition mbd, Object[] args) {
				try {
					Object bean = super.doCreateBean(beanName, mbd, args);
					return bean;
				} catch (Throwable e) {
					e.printStackTrace();
					return null;
				}
			}

			@Override
			protected void autowireByName(String beanName, AbstractBeanDefinition mbd, BeanWrapper bw, MutablePropertyValues pvs) {
				try {
					super.autowireByName(beanName, mbd, bw, pvs);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}

			@Override
			protected void autowireByType(String beanName, AbstractBeanDefinition mbd, BeanWrapper bw, MutablePropertyValues pvs) {
				try {
					super.autowireByType(beanName, mbd, bw, pvs);
				} catch (Throwable e) {
					e.printStackTrace();

				}
			}

			// if the bean class doesn't exist ,continue
			@Override
			protected Class resolveBeanClass(RootBeanDefinition mbd, String beanName, Class[] typesToMatch) {
				try {
					return super.resolveBeanClass(mbd, beanName, typesToMatch);
				} catch (Throwable e) {
					e.printStackTrace();
					return null;
				}
			}

			@Override
			protected Object initializeBean(String beanName, Object bean, RootBeanDefinition mbd) {
				try {
					return super.initializeBean(beanName, bean, mbd);
				} catch (Throwable e) {
					e.printStackTrace();
					return bean;
				}
			}

		};

	}

}
