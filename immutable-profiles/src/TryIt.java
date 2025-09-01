import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        ProfileService svc = new ProfileService();
        UserProfile p = svc.createMinimal("u1", "a@b.com");
        System.out.println("Original: " + p.getEmail());
        
        UserProfile updated = svc.withDisplayName(p, "User One");
        System.out.println("Updated profile display name: " + updated.getDisplayName());
        System.out.println("Original unchanged: " + (p.getDisplayName() == null ? "null" : p.getDisplayName()));
        System.out.println("Objects are different: " + (p != updated));
    }
}
