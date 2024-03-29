package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import exceptions.NoIdentificationException;

public class QueueTest {
	private Client c1;
	private Client c2;
	private Client c3;
	private Queue q;
	public void setupStage1(){
		q=new Queue();
		try {
			c1=new Client("1193033579");
			c2=new Client("1123443666");
			c3=new Client("1586859403");
		} catch (NoIdentificationException e) {
			e.printStackTrace();
		}
		
	}
	public void setupStage2(){
		q=new Queue();
	}
	@Test
	void testQueue() {
		setupStage1();
		
		assertNull(q.front());
	}
	@Test
	void testEnqueue() {
		setupStage1();
		
		assertEquals(null,q.front(),"The front of the queue is wrong");
		
		q.enqueue(c1);
		assertEquals(c1.getIdentification(),q.front().getIdentification(),"The front of the queue is wrong");
		assertEquals(c1.getIdentification(),q.getLast().getIdentification(),"The last of the queue is wrong");
		
		q.enqueue(c2);
		assertEquals(c1.getIdentification(),q.front().getIdentification(),"The front of the queue is wrong");
		assertEquals(c2.getIdentification(),q.getLast().getIdentification(),"The last of the queue is wrong");
		
		q.enqueue(c3);
		assertEquals(c1.getIdentification(),q.front().getIdentification(),"The front of the queue is wrong");
		assertEquals(c3.getIdentification(),q.getLast().getIdentification(),"The last of the queue is wrong");
		
	}
	@Test
	void testDequeue() {
		setupStage1();
		
		q.enqueue(c1);
		q.enqueue(c2);
		q.enqueue(c3);
		q.dequeue();	
		
		assertEquals(c2,q.front(),"The front of the queue is wrong");
		assertEquals(c3.getIdentification(),q.getLast().getIdentification(),"The last of the queue is wrong");
		
		q.dequeue();
		
		assertEquals(c3,q.front(),"The front of the queue is wrong");
		assertEquals(c3.getIdentification(),q.getLast().getIdentification(),"The last of the queue is wrong");
		
		q.dequeue();
		assertNull(q.front());
		assertNull(q.getLast());
	}
	@Test
	void tesFront() {
		setupStage1();
		assertEquals(null,q.front(),"The front of the queue is wrong");
		
		q.enqueue(c1);
		assertEquals(c1.getIdentification(),q.front().getIdentification(),"The front of the queue is wrong");
		assertEquals(c1.getIdentification(),q.getLast().getIdentification(),"The last of the queue is wrong");
		
		q.enqueue(c2);
		q.enqueue(c3);
		
		assertNotNull(q.front());
		assertEquals(c1,q.front(),"The front of the queue is wrong");
	}
	@Test
	void testEmpty() {
		setupStage2();
		boolean r=q.empty();
		assertTrue(r);
		
	}
}