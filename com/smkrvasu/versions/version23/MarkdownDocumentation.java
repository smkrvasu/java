package com.smkrvasu.versions.version23;

public class MarkdownDocumentation {
    public static void main(String[] args) {
        System.out.println(add(3, 2));
        System.out.println(multiply(3, 2));
    }

    /**
     * <p>Adds two integers.</p>
     *
     * <p><b>Parameters:</b></p>
     * <ul>
     *   <li>a - first integer</li>
     *   <li>b - second integer</li>
     * </ul>
     *
     * <p><b>Returns:</b></p>
     * <p>The sum of a and b.</p>
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /// Multiplies two integers.
    ///
    /// **Parameters:**
    /// - `a`: first integer
    /// - `b`: second integer
    ///
    /// **Returns:**
    /// The product of `a` and `b`.
    public static int multiply(int a, int b) {
        return a * b;
    }
}
