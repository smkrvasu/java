package com.smkrvasu.versions.version15;

public class TextBlocks {
    public static void main(String[] args) {
        String oldBlock = "<html>\n" +
                "    <body>\n" +
                "        <p>Hello, world</p>\n" +
                "    </body>\n" +
                "</html>\n";

        String newBlock = """
                <html>
                    <body>
                        <p>Hello, world</p>
                    </body>
                </html>
                """;
        System.out.println(oldBlock);
        System.out.println(newBlock);
    }
}
