package dev.lightdream.minereward.dto;

import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
public class Config {

    public int applicableYLevel = 20; //Or bellow
    public boolean canGetMultipleRewards = false;
    public List<Reward> rewards = Arrays.asList(
            new Reward(Arrays.asList("say %player% You have got a nice rock", "This is so rare"), 90),
            new Reward(Arrays.asList("say %player% You have got a nice rock with 95%", "This is so rare that is has a 95% chance"), 95)
    );

}
