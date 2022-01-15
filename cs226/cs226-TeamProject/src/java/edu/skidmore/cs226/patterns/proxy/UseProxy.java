package edu.skidmore.cs226.patterns.proxy;

import java.util.Scanner;

/**
 * Proxy: Demonstrate how the Proxy instance is used.
 * 
 * @author readda
 */
public class UseProxy {
    private void useWebPageProxy() {
        String[] urls = {
            "https://google.com/",
            "https://apple.com/",
            "https://monead.com/",
            "https://microsoft.com/",
            "https://www.skidmore.edu/",
            "https://redhat.com/"
        };

        ReadOnlyWebPage[] browserTabs = new ReadOnlyWebPage[urls.length];

        for (int i = 0; i < browserTabs.length; i++) {
            browserTabs[i] = new WebPageProxy(urls[i]);
        }

        @SuppressWarnings("resource")
        Scanner keyboard = new Scanner(System.in);
        String choice;

        while (true) {
            System.out.println("Which webpage would you like to see?");
            for (int i = 0; i < browserTabs.length; i++) {
                System.out.println(i + ": " + browserTabs[i].getAddress());
            }
            System.out.println("Q: quit");

            choice = keyboard.nextLine();

            if (choice.toUpperCase().equals("Q")) {
                break;
            } else {
                int c = Integer.parseInt(choice);
                System.out.println("\nURL: " + urls[c]);
                System.out.println("Error? " + browserTabs[c].hasError());
                System.out.println(
                    ("Character count: " + browserTabs[c].numCharacters()));
                System.out.println("Text: " + browserTabs[c].getPageText());
            }
        }
    }

    public static void main(String[] args) {
        UseProxy proxyCheck = new UseProxy();
        proxyCheck.useWebPageProxy();
    }
}
