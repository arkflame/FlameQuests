package com.arkflame.flamequests.enums;

public enum QuestStatus {
    /** The player has the requisites to accept the quest **/
    AVAILABLE,
    /** The player does not have the requisites to accept the quest **/
    UNAVAILABLE,
    /** The player accepted the quest **/
    ACCEPTED,
    /** The player already completed the quest **/
    COMPLETED
}