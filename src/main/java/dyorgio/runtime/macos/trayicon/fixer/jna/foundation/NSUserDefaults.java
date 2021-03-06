/*
 * The MIT License
 *
 * Copyright 2020 dyorgio.
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
package dyorgio.runtime.macos.trayicon.fixer.jna.foundation;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;

/**
 *
 * @author dyorgio
 */
public class NSUserDefaults extends NSObject {

    private static final NativeLong userDefaultsClass = Foundation.INSTANCE.objc_getClass("NSUserDefaults");
    private static final Pointer standardUserDefaultsdSel = Foundation.INSTANCE.sel_registerName("standardUserDefaults");
    private static final Pointer stringForKeySel = Foundation.INSTANCE.sel_registerName("stringForKey:");

    public NSUserDefaults(NativeLong id) {
        super(id);
    }

    public static NSUserDefaults standard() {
        return new NSUserDefaults(Foundation.INSTANCE.objc_msgSend(userDefaultsClass, standardUserDefaultsdSel));
    }

    public NSString stringForKey(NSString key) {
        return new NSString(FoundationUtil.invoke(id, stringForKeySel, key.id));
    }
}
