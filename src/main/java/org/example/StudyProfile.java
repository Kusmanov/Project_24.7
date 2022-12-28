package org.example;

public enum StudyProfile {
    MEDICINE("Медицина"),
    TELECOMMUNICATIONS("Телекоммуникации"),
    ARCHITECTURE("Архитектура");
    private final String profileName;
    StudyProfile(String profileName) {
        this.profileName = profileName;
    }
    public String getProfileName() {
        return profileName;
    }
}
