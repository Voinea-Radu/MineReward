package dev.lightdream.minereward.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Reward {

    public List<String> commands;
    public double chance;

}
