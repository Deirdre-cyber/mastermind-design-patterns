package com.example.factory;
import java.util.HashMap;
import java.util.Map;

import com.example.model.GameDifficulty;

public class SolutionInitialisationStrategyFactory {

    private final Map<GameDifficulty, SolutionInitialisationStrategy> strategies;

    public SolutionInitialisationStrategyFactory() {
        strategies = new HashMap<>();
        strategies.put(GameDifficulty.CHILDREN, new ChildrenSolutionInitialisationStrategy());
        strategies.put(GameDifficulty.CLASSIC, new ClassicSolutionInitialisationStrategy());
        strategies.put(GameDifficulty.EXPERT, new ExpertSolutionInitialisationStrategy());
    }

    public SolutionInitialisationStrategy getStrategy(GameDifficulty difficulty) {
        return strategies.get(difficulty);
    }
}
