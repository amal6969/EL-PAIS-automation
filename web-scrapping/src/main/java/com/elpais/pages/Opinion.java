package com.elpais.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Opinion {
    WebDriver driver;
    public List<String> articleTitles = new ArrayList<>();
    public List<String> articleUrls = new ArrayList<>();

    public Opinion(WebDriver driver) {
        this.driver = driver;
    }

    public void openOpinionSection() {
        driver.get("https://elpais.com/opinion/");
    }

    public void fetchArticles(int count) {
        List<WebElement> articles = driver.findElements(By.cssSelector("article a[href*='/opinion/']"));
        System.out.println("Total Articles Found: " + articles.size());

        int validCount = 0;
        for (WebElement article : articles) {
        	String url = article.getDomAttribute("href").trim();
            String title = article.getText().trim();

            if (title.isEmpty() || articleUrls.contains(url)) continue;
            if (title.equalsIgnoreCase("EDITORIAL") || title.equalsIgnoreCase("TRIBUNA") || title.equalsIgnoreCase("FIRMA INVITADA")) continue;
            if (url.contains("/editoriales/") || url.contains("/tribunas/") || url.contains("/firma-invitada/")) continue;

            articleTitles.add(title);
            articleUrls.add(url);
            validCount++;

            System.out.println("Article " + validCount + " Title: " + title);
            System.out.println("Article " + validCount + " URL: " + url);

            if (validCount >= count) break;
        }
    }

    public void printArticleContent() {
        for (int i = 0; i < articleUrls.size(); i++) {
            String title = articleTitles.get(i);
            String url = articleUrls.get(i);
            System.out.println("Title: " + title);
            System.out.println("URL: " + url);

            try {
                driver.get(url);
                WebElement contentElement = driver.findElement(By.cssSelector("h2.a_st"));
                String content = contentElement.getText();
                System.out.println("Content (Spanish): " + content);
            } catch (Exception e) {
                System.out.println("Content: No content available for this article.");
            }
            System.out.println("----------------------------------------");
        }
    }
}
