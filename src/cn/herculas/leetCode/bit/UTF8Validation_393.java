package cn.herculas.leetCode.bit;

public class UTF8Validation_393 {
    public boolean validUtf8(int[] data) {

        if (data.length == 0) return false;

        for (int i = 0; i < data.length; i++) {
            int j = 0;
            if ((data[i] & 248) == 240) j = i + 3;
            else if ((data[i] & 240) == 224) j = i + 2;
            else if ((data[i] & 224) == 192) j = i + 1;
            else if ((data[i] & 128) != 0) return false;

            i++;
            if (j > data.length - 1) return false;
            while (i <= j) {
                if ((data[i] & 192) != 128) return false;
                i++;
            }
            i--;
        }

        return true;
    }
}
