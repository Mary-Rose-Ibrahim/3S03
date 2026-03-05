// here is first attempt of generated code by Gemini 
// I had to add some fixes to the way it constructed the OrderItem and then OrderStatus it had SHIPPED but we dont have SHIPPED so I changed it to CANCELED
package com.example.shop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderTest {

    private Order order;

    @Before
    public void setUp() {
        order = new Order();
    }

    @Test
    public void testAddItem_ValidState_Success() {
        OrderItem item = new OrderItem("mary's item", 2, 10.5); // Assuming default constructor
        order.addItem(item);
        
        assertEquals(1, order.getItems().size());
        assertTrue(order.getItems().contains(item));
    }

    @Test(expected = IllegalStateException.class)
    public void testAddItem_ProcessedStatus_ThrowsException() {
        order.setStatus(OrderStatus.CANCELLED); // Transition away from CREATED
        order.addItem(new OrderItem("mary's order", 3, 10.10));
    }

    @Test
    public void testGetStatus_InitialValue_IsCreated() {
        assertEquals(OrderStatus.CREATED, order.getStatus());
    }

    @Test
    public void testSetStatus_UpdatesValue() {
        order.setStatus(OrderStatus.CANCELLED);
        assertEquals(OrderStatus.CANCELLED, order.getStatus());
    }
}