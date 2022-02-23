package com.revature.services;

import com.revature.models.CartHistory;
import com.revature.models.User;
import com.revature.repositories.CartHistoryRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;



@SpringBootTest(classes = com.revature.driver.P2backendApplication.class)
public class CartHistoryServiceTests {
    @Autowired
    CartHistoryService chs;
    @MockBean
    CartHistoryRepo chr;

    @Test
    void addCartHistory() {
        User user = new User(1, "ryanhaque", "abc123");
        CartHistory carthistory = new CartHistory(1, user, null);

        Mockito.when(chr.save(carthistory)).thenReturn(
                new CartHistory(100, carthistory.getUser(), carthistory.getDate()));

        carthistory = chs.addCartHistory(carthistory);

        Assertions.assertEquals(100, carthistory.getId());
        Assertions.assertEquals(user, carthistory.getUser());

    }
}
