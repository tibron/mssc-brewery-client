package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)

public class CustomerClient {
    private final String CUSTOMER_API = "api/v1/customer";
    private String apihost;
    private RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuider) {
        this.restTemplate = restTemplateBuider.build();
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
    //get
    public CustomerDto getCustomer(UUID id){
        //1-URL, 2 -class
        return restTemplate.getForObject(String.join("/",apihost,CUSTOMER_API,id.toString()), CustomerDto.class);
    }
    //post
    public URI saveCustomer(CustomerDto newCustomer){
        return restTemplate.postForLocation(String.join("/",apihost,CUSTOMER_API),newCustomer);
    }
    //delete
    public void deleteCustomer(UUID id){
        restTemplate.delete(String.join("/",apihost,CUSTOMER_API,id.toString()));
    }
    //put
    public void updateCusomer(UUID cutomerID, CustomerDto customerNewInformation){
        restTemplate.put(String.join("/",apihost,CUSTOMER_API,cutomerID.toString()),customerNewInformation);
    }
}
