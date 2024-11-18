package mystack;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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

	@Test
	public void testRPN()
	{
		RPN rpn = new RPN();

		String znaki = "2 2 - 1 +";

		int result = rpn.ev_RPN(znaki);

		assertEquals("RPN",1,result);
	}
	@Test
	public void testRPNZnak()
	{
		RPN rpn = new RPN();
		
		String znaki = "2 2 i 1 x";

		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            rpn.ev_RPN(znaki);
        });
        
        
        assertEquals("Niepoprawny znak: i", thrown.getMessage());
	}
	@Test
	public void testRPNDivByZero()
	{
		RPN rpn = new RPN();
		String znaki = "2 0 /";
		ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> {
			rpn.ev_RPN(znaki);
		});

		assertEquals("Dzielenie przez 0", thrown.getMessage());
	} 
}
