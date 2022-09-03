package contest.contest307;

public class A {

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int energySum = 0;
        for (int i = 0; i < energy.length; i++) {
            energySum += energy[i];
        }
        for (int i = energySum - initialEnergy + 1; ; i++) {
            for (int j = energySum - initialEnergy + 1; j <= i; j++) {
                int newEnergy = initialEnergy + j;
                int newExp = initialExperience + i - j;
                boolean isOk = true;
                for (int k = 0; k < energy.length; k++) {
                    if (newEnergy <= energy[k] || newExp <= experience[k]) {
                        isOk = false;
                        break;
                    }
                    newEnergy -= energy[k];
                    newExp += experience[k];
                }
                if (isOk) {
                    return Math.max(0, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
