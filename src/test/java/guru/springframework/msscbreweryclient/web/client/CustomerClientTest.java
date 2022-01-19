package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient cutomerRestClient;

    @Test
    void getCustomer() {
        CustomerDto testOut = cutomerRestClient.getCustomer(UUID.randomUUID());
        assertNotNull(testOut);
    }

    @Test
    void saveCustomer() {
        CustomerDto saveCustomer = CustomerDto.builder().id(UUID.randomUUID()).name("Random Customer").build();
        URI uri = cutomerRestClient.saveCustomer(saveCustomer);
        assertNotNull(uri);
        System.out.println(uri);

    }

    @Test
    void deleteCustomer() {
        UUID removeByUUID = UUID.randomUUID();
        cutomerRestClient.deleteCustomer(removeByUUID);
    }

    @Test
    void updateCusomer() {
        CustomerDto updateCustomer = CustomerDto.builder().id(UUID.randomUUID()).name("Random Customer").build();
        cutomerRestClient.updateCusomer(UUID.randomUUID(), updateCustomer);
    }
}