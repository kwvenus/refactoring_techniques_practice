package com.tws.refactoring.extract_variable;

public class BannerRender {
    public static void renderBanner(String platform, String browser) {
        if ((isIncludeKeyword(platform, "MAC")) &&
                (isIncludeKeyword(browser, "IE"))) {
            // do something
            System.out.print("Success");
        }
    }

    private static boolean isIncludeKeyword(String inputString, String keyword){
        return inputString.toUpperCase().indexOf(keyword) > -1;
    }
}
