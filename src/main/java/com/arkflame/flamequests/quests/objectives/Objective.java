package com.arkflame.flamequests.quests.objectives;

public abstract class Objective {

    /**
     * Load the objective data from a splitted string
     * 
     * @param rawObjective Text objectives separated by ", "
     * @param success Code to execute when loaded
     */
    public abstract void load(String[] rawObjective);

    /**
     * Register this objective on the Bukkit listeners it's required to work
     */
    public abstract void registerListeners();
}
