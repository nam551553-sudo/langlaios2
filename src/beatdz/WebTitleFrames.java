package beatdz;

import java.util.Arrays;

/** Frame IDs absent from the supplied title artwork; retain the real frames in order. */
public final class WebTitleFrames {
    private WebTitleFrames() {}
    public static int[] available(int[] frames) {
        int[] result = new int[frames.length];
        int count = 0;
        for (int id : frames) {
            if ((id >= 9356 && id <= 9388) || id == 21055 || id == 21056) continue;
            result[count++] = id;
        }
        return Arrays.copyOf(result, count);
    }
}
