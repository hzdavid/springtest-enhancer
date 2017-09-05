What is springtest-enhancer ?

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

it will be ignored. As long as the beans that are related to your program are instantiated and initialized normally , your test program will

be not blocked and move on.
 


How to use ?


Here are some demos for you.

https://github.com/hzdavid/springtest-enhancer-demo

Please git clone it ,try to run/debug it in your ide. I am sure you will find that springtest-enhancer is useful if you write test program by spring test.

If you have some problems or suggestions, you can send mail to me at hzdavid2009@gmail.com. My name is david!


  




