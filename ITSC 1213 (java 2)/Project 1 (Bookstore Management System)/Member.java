
package trojanowskideanproject;

public class Member {
    private String name;
    private String subscriptionType;
    private double subscriptionFee;

    public Member(String name, String subscriptionType) {
        this.name = name;
        this.subscriptionType = subscriptionType;
        if (subscriptionType.equals("Free-tier")) {
            this.subscriptionFee = 0;
        } else if (subscriptionType.equals("Premium")) {
            this.subscriptionFee = 9.99;
        }
    }

    public String getName() {
        return name;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public double getSubscriptionFee() {
        return subscriptionFee;
    }
}