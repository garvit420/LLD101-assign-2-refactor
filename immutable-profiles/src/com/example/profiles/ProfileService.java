package com.example.profiles;

/**
 * Assembles profiles with scattered, inconsistent validation.
 */
public class ProfileService {

    public UserProfile createMinimal(String id, String email) {
        return UserProfile.builder(id, email).build();
    }

    public UserProfile withDisplayName(UserProfile profile, String displayName) {
        return UserProfile.builder(profile.getId(), profile.getEmail())
                .phone(profile.getPhone())
                .displayName(displayName)
                .address(profile.getAddress())
                .marketingOptIn(profile.isMarketingOptIn())
                .twitter(profile.getTwitter())
                .github(profile.getGithub())
                .build();
    }
}
