# What is springtest-enhancer ?

It is a jar ,an enhancement jar of spring test, which can help you improve you test program based on spring test.

Let's have an overview.

Spring test program is usually like this.

	@ContextConfiguration(locations = { "./applicationContext.xml" })
	@RunWith(SpringJUnit4ClassRunner.class)
	public class HelloWorldTest {
	...
	}

but this test program is easily to fail as long as  one of beans  managed  by spring  meet some exceptions or errors such as ClassNotFoundException,BeanInitException,InjectFailure. 
So your test program may be blocked.Although  these beans are not related your target beans to be testing.

But with  springtest-enhancer, only what you need to  change is to add loader property to ContextConfiguration.

It looks like that :

	@ContextConfiguration(locations = { "./applicationContext.xml" }, loader = SpringTestEnhancerContextLoader.class)
	@RunWith(SpringJUnit4ClassRunner.class)
	public class HelloWorldTest {
	...
	}

You can get benefits that your test program becomes much more robust. Although some beans  managed  by spring  meet some exceptions or errors,

it will be ignored. As long as the beans that are related to your program are instantiated and initialized normally , your test program will be not blocked and move on.
 


# How to use ?


Here are some demos for you.

https://github.com/hzdavid/springtest-enhancer-demo

Please git clone it ,try to run/debug it in your ide. I am sure you will find that springtest-enhancer is useful if you write test program by spring test.


If you have some problems or suggestions, you can send mail to me at hzdavid2009@gmail.com. My name is david!


  






*** 
In Chinese:



# 什么是 springtest-enhancer ?

 它是一个jar包，一个对springtest增强包，可以改进spring test测试程序的jar包。
 

让我们看一下，

基于Spring test 的程序通常是这样的：
 
	@ContextConfiguration(locations = { "./applicationContext.xml" })
	@RunWith(SpringJUnit4ClassRunner.class)
	public class HelloWorldTest {
	...
	}
 
但是这样的程序很容易失败，只要被spring管理的bean在实列化或初始化的时候，遇到异常或失败(比如类找不到了，bean初始化方法执行异常了，依赖注入失败了)，

整个spring容器就会初始化失败。 尽管这些bean与你要测试的bean不相关，但是你的测试程序依然受阻了。


如果用了springtest-enhancer， 你只需要给ContextConfiguration增加一个loader属性，就可以解决这个问题。
例如:

	@ContextConfiguration(locations = { "./applicationContext.xml" }, loader = SpringTestEnhancerContextLoader.class)
	@RunWith(SpringJUnit4ClassRunner.class)
	public class HelloWorldTest {
	...
	} 


于是，你的测试程序会变得更加健壮，
尽管spring管理的bean在实列化或初始化的时候，遇到异常或失败，但只要这些bean与你要测试的bean不相关，你的测试程序依然会继续执行。减少你的测试程序受阻的可能性。
进而，提升spring test程序的通过率。


 
# 如何使用？

这里是一些使用springtest-enhancer的例子：
 
https://github.com/hzdavid/springtest-enhancer-demo

你可以下载，并在你的开发工具中运行或调试它，如果你是用spring test写测试程序,你会发现springtest-enhancer会很有用.

如果你什么问题或建议，可以写邮件给我。hzdavid2009@gmail.com。 我叫大伟。

 







