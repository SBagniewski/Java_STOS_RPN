package mystack;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import mystack.MyStack;  // Import MyStack

public class StackTest {

    @Test
    public void testPush() {
        MyStack stack = new MyStack();
        stack.push("test");
        String result = stack.peek();
        assertEquals("asd","test", result);
    }

	@Test
	public void testPop()
	{
		MyStack stack = new MyStack();
		stack.push("test1");
		stack.push("test2");
		stack.pop();
		String result1=stack.peek();
		int result2 = stack.size();
		assertEquals("pop_value","test1",result1);
		assertEquals("pop_size",1,result2);
	}

	@Test
	public void testPeek()
	{
		MyStack stack = new MyStack();
		stack.push("test");
		String res1=stack.peek();
		int res2=stack.size();
		assertEquals("peek_value","test",res1);
		assertEquals("peek_size",1,res2);
	}
}
