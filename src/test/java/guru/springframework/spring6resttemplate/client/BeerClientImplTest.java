package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientImplTest {

    @Autowired
    BeerClientImpl beerClient;


    @Test
    void getBeerById() {

        Page<BeerDTO> beerDTOS = beerClient.listBeers();
        BeerDTO beerDTO = beerDTOS.getContent().get(0);
        BeerDTO beerDTOById = beerClient.getBeerById(beerDTO.getId());
        assertNotNull(beerDTOById);
    }

    @Test
    void listBeersNoBeerName() {
        beerClient.listBeers(null, null, null, null, null);
    }

    @Test
    void listBeers() {

        beerClient.listBeers("ALE", null, null, null, null);
    }





}
