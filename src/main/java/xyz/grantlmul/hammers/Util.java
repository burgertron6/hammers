package xyz.grantlmul.hammers;

import net.minecraft.entity.LivingEntity;

public class Util {

    /*
     * N=0
     * E=1
     * S=2
     * W=3
     */
    static int GetCardinalDirection(LivingEntity entity) {
        float direction = entity.getHorizontalFacing().asRotation();
        if (direction > 135 || direction < -135) {
            return 0;
        }
        if (direction > -135 && direction < -45) {
            return 1;
        }
        if (direction > -45 && direction < 45) {
            return 2;
        }
        if (direction > 45 && direction < 135) {
            return 3;
        }
    }
}
