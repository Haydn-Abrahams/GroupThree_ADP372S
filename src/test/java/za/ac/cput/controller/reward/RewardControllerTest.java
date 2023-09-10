/** RewardControllerTest.java
 *  This class test the controller
 *  Andrea Jacobs 218024266
 *  10 September 2023 */

package za.ac.cput.controller.reward;

import org.eclipse.jetty.http.HttpHeader;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.reward.Reward;
import za.ac.cput.domain.reward.Tier;
import za.ac.cput.factory.reward.RewardFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RewardControllerTest {
    Reward reward = RewardFactory.createReward(500, Tier.PLATINUM);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/reward";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Reward> postResponse = restTemplate.postForEntity(url, reward, Reward.class);
        assertNotNull(postResponse);
        Reward saveReward = postResponse.getBody();
        System.out.println("Save data: " + saveReward);
        assertEquals(reward.getRewardId(), saveReward.getRewardId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read" + reward.getRewardId();
        System.out.println("URL: " + url);
        ResponseEntity<Reward> response = restTemplate.getForEntity(url, Reward.class);
        assertEquals(reward.getRewardId(), response.getBody().getRewardId());
        System.out.println(response.getBody());
    }

    @Disabled
    @Test
    void c_update() {
        //Reward updated = new Reward.Builder().copy(reward.earnPoints(05).build();
    }

    @Test
    void d_delete() {
        String url = baseURL + "/delete" + reward.getRewardId();
        System.out.println("URL" + url);
        restTemplate.delete(url);
    }

    @Test
    void e_getAll() {
        String url = baseURL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}