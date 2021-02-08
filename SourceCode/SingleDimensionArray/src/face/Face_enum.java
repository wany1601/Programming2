/*
 * The MIT License
 *
 * Copyright 2021 Yi Wang.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package face;

import java.util.Random;

enum MouthColor {
    RED,
    PINK,
    ORANGE
}

/**
 * A simple class of face (using enum to add restriction to mouthColor)
 *
 * @author Yi Wang
 */
public class Face_enum {

    private int eyeType;
    private int noseType;
    private MouthColor mouthColor;      // RED PINK ORANGE

    private static final int MAX_EYE_TYPE = 2;
    private static final int MAX_NOSE_TYPE = 2;

    public Face_enum() {
        Random rand = new Random();
        this.eyeType = rand.nextInt(MAX_EYE_TYPE + 1);
        this.noseType = rand.nextInt(MAX_NOSE_TYPE + 1);
        this.mouthColor = MouthColor.values()[rand.nextInt(MouthColor.values().length)];
    }

    public Face_enum(int eyeType, int noseType, MouthColor mouthColor) {
        this.eyeType = (eyeType >= 0 && eyeType < MAX_EYE_TYPE) ? eyeType : 0;
        this.noseType = (noseType >= 0 && noseType < MAX_NOSE_TYPE) ? noseType : 0;
        this.mouthColor = mouthColor;
    }

    public void setEyeType(int eyeType) {
        if (eyeType >= 0 && eyeType < MAX_EYE_TYPE)
            this.eyeType = eyeType;
    }

    public void setNoseType(int noseType) {
        if (noseType >= 0 && noseType < MAX_NOSE_TYPE)
            this.noseType = noseType;
    }

    public void setMouthColor(MouthColor mouthColor) {
        this.mouthColor = mouthColor;
    }

}
