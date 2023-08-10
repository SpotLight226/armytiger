package com.army.armytiger.enums;

public enum Rank {
    PRIVATE("이병"),
    PRIVATE_FIRST_CLASS("일병"),
    CORPORAL("상병"),
    SERGEANT("병장"),
    STAFF_SERGEANT("하사"),
    SERGEANT_FIRST_CLASS("중사"),
    MASTER_SERGEANT("상사"),
    SERGEANT_MAJOR("원사"),
    WARRANT_OFFICER_CANDIDATE("준위"),
    WARRANT_OFFICER("소위"),
    CHIEF_WARRANT_OFFICER_SECOND_CLASS("중위"),
    CHIEF_WARRANT_OFFICER_FIRST_CLASS("대위"),
    SECOND_LIEUTENANT("소령"),
    FIRST_LIEUTENANT("중령"),
    CAPTAIN("대령"),
    BRIGADIER_GENERAL("준장"),
    MAJOR("소장"),
    LIEUTENANT_GENERAL("중장"),
    GENERAL("대장");

    private final String label;

    Rank(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
