import java.util.Arrays;

public class OTPGenerator {
    static int generateOTP() {
        return (int)(100000 + Math.random() * 900000); 
    }

    static int[] generateMultipleOTPs(int count) {
        int[] otps = new int[count];
        for (int i = 0; i < count; i++) {
            otps[i] = generateOTP();
        }
        return otps;
    }

    static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otps = generateMultipleOTPs(10);
        System.out.println("Generated OTPs: " + Arrays.toString(otps));

        if (areOTPsUnique(otps)) {
            System.out.println("All OTPs are unique.");
        } else {
            System.out.println("Some OTPs are repeated.");
        }
    }
}
