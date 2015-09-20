import static org.junit.Assert.*;

import org.junit.Test;

public class DLinkedListTester {

	@Test
	public void test() {
		DLinkedList<Integer> b= new DLinkedList<Integer>(); 
		assertEquals("[]", b.toString());
		assertEquals("[]", b.toStringRev());
		assertEquals(0, b.size());
	}
	@Test
	public void testPrepend() {
		DLinkedList<String> ll= new DLinkedList<String>();
		DLinkedList<String>.Node n= ll.prepend("Foster");
		assertEquals("[Foster]", ll.toString());
		assertEquals("[Foster]", ll.toStringRev());
		assertEquals(1, ll.size());
		assertEquals(ll.getHead(), n);
		DLinkedList<String>.Node n2= ll.prepend("XMAS");
		assertEquals(2, ll.size());
		assertEquals(ll.getHead(), n2);
		assertEquals("[XMAS, Foster]", ll.toString());
		assertEquals("[Foster, XMAS]", ll.toStringRev());		
	}
	
	@Test
	public void testMETHODS() {
		DLinkedList<String> ll= new DLinkedList<String>();
		DLinkedList<String>.Node n1= ll.prepend("WENr");
		DLinkedList<String>.Node n2= ll.append("YU");
		assertEquals("[WENr, YU]", ll.toString());
		assertEquals("[YU, WENr]", ll.toStringRev());
		assertEquals(2, ll.size());
		assertEquals(ll.getHead(), n1);
		assertEquals(ll.getTail(), n2);
		DLinkedList<String>.Node n3= ll.prepend("HOHO");
		assertEquals("[HOHO, WENr, YU]", ll.toString());
		assertEquals("[YU, WENr, HOHO]", ll.toStringRev());
		assertEquals(3, ll.size());
		assertEquals(ll.getHead(), n3);
		assertEquals(ll.getTail(), n2);
		DLinkedList<String>.Node n4= ll.append("YAHEY");
		assertEquals("[YAHEY, YU, WENr, HOHO]", ll.toStringRev());
		assertEquals(4, ll.size());
		assertEquals(ll.getHead(), n3);
		assertEquals(ll.getTail(), n4);
		
		// INSERT AFTER//
		DLinkedList<String>.Node n5= ll.insertAfter("HORAY", n2);
		assertEquals("[HOHO, WENr, YU, HORAY, YAHEY]", ll.toString());
		assertEquals(ll.getHead(), n3);
		assertEquals(ll.getTail(), n4);
		assertEquals(5, ll.size());
		// INSERT AFTER TAIL//
		DLinkedList<String>.Node n6= ll.insertAfter("COOL", n4);
		assertEquals("[HOHO, WENr, YU, HORAY, YAHEY, COOL]", ll.toString());
		assertEquals(6, ll.size());
		assertEquals(ll.getHead(), n3);
		assertEquals(ll.getTail(), n6);
		
		// INSERT BEFORE//
		DLinkedList<String>.Node n7= ll.insertBefore("shuuuu", n2);
		assertEquals("[HOHO, WENr, shuuuu, YU, HORAY, YAHEY, COOL]", ll.toString());
		assertEquals(7, ll.size());
		assertEquals(ll.getHead(), n3);
		assertEquals(ll.getTail(), n6);
		// INSERT BEFORE HEAD//
		DLinkedList<String>.Node n8= ll.insertBefore("TAIWAN", n3);
		assertEquals("[TAIWAN, HOHO, WENr, shuuuu, YU, HORAY, YAHEY, COOL]", ll.toString());
		assertEquals(8, ll.size());
		assertEquals(ll.getHead(), n8);
		assertEquals(ll.getTail(), n6);
		
		// REMOVE//
		ll.remove(n3);
		assertEquals(7, ll.size());
		assertEquals("[TAIWAN, WENr, shuuuu, YU, HORAY, YAHEY, COOL]", ll.toString());
		
		// REMOVE TAIL AND HEAD //
		ll.remove(n6);
		assertEquals(6, ll.size());
		assertEquals("[TAIWAN, WENr, shuuuu, YU, HORAY, YAHEY]", ll.toString());
		assertEquals(ll.getHead(), n8);
		assertEquals(ll.getTail(), n4);
		
		ll.remove(n8);
		assertEquals(5, ll.size());
		assertEquals("[WENr, shuuuu, YU, HORAY, YAHEY]", ll.toString());
		assertEquals(ll.getHead(), n1);
		assertEquals(ll.getTail(), n4);
		
		
	}
	
}