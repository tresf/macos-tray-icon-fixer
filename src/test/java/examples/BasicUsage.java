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
package examples;

import dyorgio.runtime.macos.trayicon.fixer.MacOSTrayIconFixer;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

/**
 *
 * @author dyorgio
 */
public class BasicUsage {

    /**
     * --add-opens java.desktop/sun.lwawt.macosx=ALL-UNNAMED
     *
     * @param args
     * @throws IOException
     * @throws AWTException
     */
    public static void main(String[] args) throws IOException, AWTException {

        Image blackImage = ImageIO.read(BasicUsage.class.getResource("/mactray22@2x.png"));
        Image whiteImage = ImageIO.read(BasicUsage.class.getResource("/mactray-white22@2x.png"));

        TrayIcon icon = new TrayIcon(MacOSTrayIconFixer.getInitialIcon(blackImage, whiteImage), "Teste");
        icon.addActionListener((e) -> System.out.println("examples.BasicUsage.main():" + SwingUtilities.isEventDispatchThread()));
        SystemTray.getSystemTray().add(icon);

        MacOSTrayIconFixer.fix(icon, blackImage, whiteImage, false, 0);
    }
}
