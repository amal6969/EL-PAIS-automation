package com.elpais.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.elpais.pages.Opinion;

import io.cucumber.java.en.*;

public class OpinionScrappingSteps {

    WebDriver driver;
    Opinion opinionPage;

    @Given("I visit the El Pais Opinion section")
    public void i_visit_the_el_pais_opinion_section() {
        driver = new ChromeDriver();
        opinionPage = new Opinion(driver);
        opinionPage.openOpinionSection();
    }

    @When("I fetch the first {int} articles")
    public void fetchArticles(int count) {
        opinionPage.fetchArticles(count);
    }

    @Then("I print the title and content of each article in Spanish")
    public void printArticleDetails() {
        opinionPage.printArticleContent();
        driver.quit();
    }
}
