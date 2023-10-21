/** Reward.java
 *  This is POJO class
 *  Andrea Jacobs 218024266
 *  08 September 2023  */

package za.ac.cput.domain.reward;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
//@IdClass(Reward.class)
public class Reward implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String rewardId;
    //private Customer customer;
    private Tier tier;
    private int points;

    protected Reward(){}

    private Reward(Builder builder){
        this.rewardId = builder.rewardId;
        this.tier = builder.tier;
        this.points = builder.points;
    }

    public String getRewardId() {
        return rewardId;
    }

    public Tier getTier() {
        return tier;
    }

    public int getPoints() {
        return points;
    }

    public void earnPoints(int pointsEarned) {
        this.points += pointsEarned;
        updateRewardTier();
    }

    private void updateRewardTier() {
        if (points >= 1000) {
            tier = Tier.PLATINUM;
        } else if (points >= 500) {
            tier = Tier.GOLD;
        } else if (points >= 250) {
            tier = Tier.SILVER;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return points == reward.points && Objects.equals(rewardId, reward.rewardId) && tier == reward.tier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardId, tier, points);
    }

    @Override
    public String toString() {
        return "Reward{" +
                "rewardId='" + rewardId + '\'' +
                ", tier=" + tier +
                ", points=" + points +
                '}';
    }

    public static class Builder{
        private String rewardId;
        //private Customer customer;
        private Tier tier;
        private int points = 0;

        public Builder setRewardId(String rewardId) {
            this.rewardId = rewardId;
            return this;
        }

        public Builder setTier(Tier tier) {
            this.tier = tier;
            return this;
        }

        public Builder setPoints(int points) {
            this.points = points;
            return this;
        }


        public Builder copy(Reward reward){
            this.rewardId = reward.rewardId;
            this.tier = reward.tier;
            this.points = reward.points;
            return this;
        }

        public Reward build(){
            return new Reward(this);
        }
    }
}
