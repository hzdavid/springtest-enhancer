什么是 springtest-enhancer ?

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
例如：
@ContextConfiguration(locations = { "./applicationContext.xml" }, loader = SpringTestEnhancerContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldTest {
...
} 


于是，你的测试程序会变得更加健壮，
尽管spring管理的bean在实列化或初始化的时候，遇到异常或失败，但只要这些bean与你要测试的bean不相关，你的测试程序依然会继续执行。减少你的测试程序受阻的可能性。
进而，提升spring test程序的通过率。


 
如何使用？

这里是一些使用springtest-enhancer的例子：
 
https://github.com/hzdavid/springtest-enhancer-demo

你可以下载，并在你的开发工具中运行或调试它，你会发现springtest-enhancer会很有用,如果你是用spring test写测试程序。

如果你什么问题或建议，可以写邮件给我。hzdavid2009@gmail.com。 我叫大伟。

 



