/** RewardController.java
 *  This sets the controller
 *  Andrea Jacobs 218024266
 *  10 September 2023 */

package za.ac.cput.controller.reward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.reward.Reward;
import za.ac.cput.service.reward.RewardService;

import java.util.Set;

@RestController
@RequestMapping("/reward")
public class RewardController {

    private RewardService service;
    @Autowired
    public RewardController(RewardService service) {
        this.service = service;
    }


    @PostMapping("/create")
    public Reward create(@RequestBody Reward reward){
        return service.create(reward);
    }

    @GetMapping("/read{id}")
    public Reward read(@PathVariable String rewardId){
        return service.read(rewardId);
    }

    @PostMapping("/update")
    public Reward update(@RequestBody Reward reward){
        return service.update(reward);
    }

    @DeleteMapping("/delete{id}")
    public boolean delete(@PathVariable String rewardId){
        return service.delete(rewardId);
    }

    @GetMapping("/getAll")
    public Set<Reward> getAll(){
        return service.getAll();
    }

}
